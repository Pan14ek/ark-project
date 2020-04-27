package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.service.UserService
import ua.nure.makieiev.ark.util.converter.UserConverter
import java.util.*

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(var userService: UserService,
                                            var userConverter: UserConverter) {

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


}