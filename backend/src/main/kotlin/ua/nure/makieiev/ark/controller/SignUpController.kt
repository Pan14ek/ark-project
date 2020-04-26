package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.nure.makieiev.ark.exception.NotUniqueUserFieldException
import ua.nure.makieiev.ark.exception.response.ConflictException
import ua.nure.makieiev.ark.model.dto.UserDto
import ua.nure.makieiev.ark.service.UserService
import ua.nure.makieiev.ark.util.converter.UserConverter
import ua.nure.makieiev.ark.util.validation.UserValidator

@RestController
@RequestMapping("/user")
class SignUpController @Autowired constructor(var userService: UserService,
                                              var userValidator: UserValidator,
                                              var userConverter: UserConverter) {

    @PostMapping(value = ["/signUp"], produces = ["application/json"])
    fun signUp(@RequestBody userDto: UserDto): ResponseEntity<Any> {
        try {
            val errors: MutableList<String> = userValidator.signUpValidate(userDto)
            return if (errors.isEmpty()) {
                signUpProcess(userDto)
            } else {
                ResponseEntity(errors, HttpStatus.BAD_REQUEST)
            }
        } catch (notUniqueUserFieldException: NotUniqueUserFieldException) {
            throw ConflictException(notUniqueUserFieldException.message)
        }
    }

    private fun signUpProcess(userDto: UserDto): ResponseEntity<Any> {
        var user = userConverter.fillUser(userDto)
        user = userService.save(user)
        return ResponseEntity(user, HttpStatus.OK)
    }

}