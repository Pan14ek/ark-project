package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.dto.UserPlaceDto
import ua.nure.makieiev.ark.model.entity.UserPlace
import ua.nure.makieiev.ark.service.UserPlaceService
import ua.nure.makieiev.ark.service.UserService
import ua.nure.makieiev.ark.service.WorkPlaceService
import javax.validation.Valid

@RestController
@RequestMapping("/place")
class UserPlaceController @Autowired constructor(private val userService: UserService,
                                                 private val workPlaceService: WorkPlaceService,
                                                 private val userPlaceService: UserPlaceService) {

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addUserPlace(@RequestBody @Valid userPlaceDto: UserPlaceDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val userPlace = obtainUserPlace(userPlaceDto)
            ResponseEntity(userPlaceService.save(userPlace), CREATED)
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("user/{id}")
    fun findByUserId(@PathVariable id: Long): ResponseEntity<Any> {
        val userPlace: UserPlace? = userPlaceService.findByUserId(id)
        userPlace?.let { return ResponseEntity(userPlace, OK) }
        throw NotFoundException("User place did not find by user id")
    }

    fun obtainUserPlace(userPlaceDto: UserPlaceDto): UserPlace {
        val userPlace = UserPlace()
        val userOptional = userService.findById(userPlaceDto.userId)
        val workPlaceOptional = workPlaceService.findById(userPlaceDto.workPlaceId)
        if (userOptional.isPresent && workPlaceOptional.isPresent) {
            userPlace.user = userOptional.get()
            userPlace.workPlace = workPlaceOptional.get()
        }
        return userPlace
    }

}