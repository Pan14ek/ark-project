package ua.nure.makieiev.ark.configuration

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.apache.commons.lang3.StringUtils
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.*
import java.util.stream.Collectors

@Component
class TokenProvider : Serializable {

    fun generateToken(authentication: Authentication): String? {
        val authorities: String = authentication.authorities.stream()
                .map { obj: GrantedAuthority -> obj.authority }
                .collect(Collectors.joining(COMMA))
        return Jwts.builder()
                .setSubject(authentication.name)
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(calculateTime()))
                .compact()
    }

    fun validateToken(token: String?, userDetails: UserDetails): Boolean? {
        val username: String = getLoginFromToken(token)
        return username == userDetails.username && !isTokenExpired(token!!)!!
    }

    fun getAuthentication(token: String?,
                          existingAuth: Authentication?,
                          userDetails: UserDetails?): UsernamePasswordAuthenticationToken? {
        val jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY)
        val claimsJws = jwtParser.parseClaimsJws(token)
        val claims = claimsJws.body
        val authorities: Collection<GrantedAuthority?> = Arrays.stream(claims[AUTHORITIES_KEY].toString()
                .split(COMMA).toTypedArray())
                .map { role: String? -> SimpleGrantedAuthority(role) }
                .collect(Collectors.toList())
        return UsernamePasswordAuthenticationToken(userDetails, StringUtils.EMPTY, authorities)
    }

    fun getLoginFromToken(token: String?): String {
        val claims: Claims? = token?.let { getAllClaimsFromToken(it) }
        return claims!!.subject
    }

    private fun getExpirationDateFromToken(token: String?): Date {
        val claims: Claims? = token?.let { getAllClaimsFromToken(it) }
        return claims!!.expiration
    }

    private fun getAllClaimsFromToken(token: String): Claims {
        return Jwts.parser().setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .body
    }

    private fun isTokenExpired(token: String): Boolean? {
        val expiration: Date = getExpirationDateFromToken(token)
        return expiration.before(Date())
    }

    private fun calculateTime(): Long {
        return System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * ONE_THOUSAND
    }

    companion object {
        const val SIGNING_KEY: String = "asd(@32]pdas-=13"
        const val AUTHORITIES_KEY: String = "scopes"
        const val ACCESS_TOKEN_VALIDITY_SECONDS: Long = 5 * 60 * 60
        const val ONE_THOUSAND: Int = 1000
        const val COMMA: String = ","
    }

}