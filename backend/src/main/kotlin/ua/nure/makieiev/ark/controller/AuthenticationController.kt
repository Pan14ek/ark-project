package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.nure.makieiev.ark.configuration.TokenProvider
import ua.nure.makieiev.ark.exception.response.BadRequestException
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.dto.LoginUser
import ua.nure.makieiev.ark.model.entity.AuthToken
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.service.UserService

@RestController
@RequestMapping("/user")
class AuthenticationController @Autowired constructor(var authenticationManager: AuthenticationManager,
                                                      var jwtTokenUtil: TokenProvider,
                                                      var userService: UserService) {

    @PostMapping("/signIn")
    fun signIn(@RequestBody loginUser: LoginUser, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val user: User? = userService.findByLogin(loginUser.login)
            user?.let { return checkUserPassword(it, loginUser) }
            throw NotFoundException("User did not find by login")
        }
    }

    private fun checkUserPassword(user: User, loginUser: LoginUser): ResponseEntity<Any> {
        if (userService.checkPassword(user, loginUser.password)) {
            val token: String = obtainToken(loginUser)
            return ResponseEntity(AuthToken(token, user), OK)
        }
        throw BadRequestException("Login or password is incorrect")
    }

    private fun obtainToken(loginUser: LoginUser): String {
        val authentication: Authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(loginUser.login, loginUser.password))
        SecurityContextHolder.getContext().authentication = authentication
        return jwtTokenUtil.generateToken(authentication) as String
    }

}