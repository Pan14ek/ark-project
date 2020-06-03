package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.dto.UserUpdateDto
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.service.UserService
import ua.nure.makieiev.ark.util.converter.impl.UserConverter
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(private val userService: UserService,
                                            private val userConverter: UserConverter) {

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val user: Optional<User> = userService.findById(id)
        if (user.isPresent) {
            return ResponseEntity(user.get(), OK)
        }
        throw NotFoundException("User did not find by id")
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/login/{login}")
    fun findByLogin(@PathVariable login: String): ResponseEntity<Any> {
        val user: User? = userService.findByLogin(login)
        user?.let { return ResponseEntity(user, OK) }
        throw NotFoundException("User did not find by login")
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/all")
    fun findAll(): ResponseEntity<Any> {
        return ResponseEntity(userService.findAll(), OK)
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @PutMapping(value = ["/update"], produces = ["application/json"])
    fun update(@RequestBody @Valid userUpdateDto: UserUpdateDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val userOptional: Optional<User> = userService.findById(userUpdateDto.id)
            if (userOptional.isPresent) {
                val user = userOptional.get()
                user.login = userUpdateDto.login
                user.email = userUpdateDto.email
                user.firstName = userUpdateDto.firstName
                user.lastName = userUpdateDto.lastName
                val updateFlag = userService.update(user)
                if (updateFlag) {
                    ResponseEntity(user, OK)
                } else {
                    ResponseEntity(updateFlag, BAD_REQUEST)
                }
            }
            throw NotFoundException("User did not find by id")
        }
    }

}