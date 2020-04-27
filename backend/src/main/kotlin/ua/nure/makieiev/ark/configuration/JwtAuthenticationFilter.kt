package ua.nure.makieiev.ark.configuration

import io.jsonwebtoken.SignatureException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import javax.annotation.Resource
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JwtAuthenticationFilter : OncePerRequestFilter() {

    @Resource(name = "userService")
    lateinit var userDetailsService: UserDetailsService

    @Autowired
    lateinit var jwtTokenUtil: TokenProvider

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val header = request.getHeader(HEADER_STRING)
        var login: String? = null
        var authToken: String? = null
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX, "")
            try {
                login = jwtTokenUtil.getLoginFromToken(authToken)
            } catch (e: IllegalArgumentException) {
                logger.error("an error occured during getting username from token", e)
            } catch (e: SignatureException) {
                logger.error("Authentication Failed. Username or Password not valid.")
            }
        } else {
            logger.warn("couldn't find bearer string, will ignore the header")
        }
        if (login != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = userDetailsService.loadUserByUsername(login)
            if (jwtTokenUtil.validateToken(authToken, userDetails)!!) {
                val authentication = jwtTokenUtil.getAuthentication(authToken, SecurityContextHolder
                        .getContext().authentication, userDetails)
                authentication!!.details = WebAuthenticationDetailsSource().buildDetails(request)
                logger.info("authenticated user $login, setting security context")
                SecurityContextHolder.getContext().authentication = authentication
            }
        }
        filterChain.doFilter(request, response)
    }

    companion object {
        const val TOKEN_PREFIX: String = "Bearer "
        const val HEADER_STRING: String = "Authorization"
    }

}