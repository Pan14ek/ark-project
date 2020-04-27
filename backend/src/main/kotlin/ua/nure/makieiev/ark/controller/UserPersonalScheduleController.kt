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
import ua.nure.makieiev.ark.model.dto.ConfirmUserPersonalSchedule
import ua.nure.makieiev.ark.model.dto.UserPersonalScheduleDto
import ua.nure.makieiev.ark.model.entity.UserPersonalSchedule
import ua.nure.makieiev.ark.service.PersonalScheduleService
import ua.nure.makieiev.ark.service.UserPersonalScheduleService
import ua.nure.makieiev.ark.service.UserService
import java.time.LocalDate
import javax.validation.Valid

@RestController
@RequestMapping("/user/person/schedule")
class UserPersonalScheduleController @Autowired constructor(private val userPersonalScheduleService: UserPersonalScheduleService,
                                                            private val userService: UserService,
                                                            private val personalScheduleService: PersonalScheduleService) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addUserPersonalSchedule(@RequestBody @Valid userPersonalScheduleDto: UserPersonalScheduleDto,
                                bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val personalSchedule = userPersonalScheduleDto.personalScheduleId?.let { personalScheduleService.findById(it) }
            val user = userPersonalScheduleDto.userLogin?.let { userService.findByLogin(it) }
            val userPersonalSchedule = UserPersonalSchedule()
            if (personalSchedule!!.isPresent) {
                userPersonalSchedule.personalSchedule = personalSchedule.get()
                userPersonalSchedule.user = user
                userPersonalSchedule.confirm = false
                ResponseEntity(userPersonalScheduleService.save(userPersonalSchedule), CREATED)
            }
            throw NotFoundException("Personal schedule did not find by id")
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @PostMapping(value = ["/confirm"], produces = ["application/json"])
    fun confirmPersonalSchedule(@RequestBody @Valid confirmUserPersonalSchedule: ConfirmUserPersonalSchedule,
                                bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val userPersonalScheduleOptional = confirmUserPersonalSchedule.userPersonalScheduleId?.let { userPersonalScheduleService.findById(it) }
            if (userPersonalScheduleOptional!!.isPresent) {
                var userPersonalSchedule = userPersonalScheduleOptional.get()
                userPersonalSchedule = confirmUserPersonalSchedule.confirm?.let { userPersonalScheduleService.confirmPersonalSchedule(it, userPersonalSchedule) }!!
                ResponseEntity(userPersonalSchedule, OK)
            }
            throw NotFoundException("Personal schedule did not find by id")
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{userId}/{workDate}")
    fun findByUserIdAndWorkDate(@PathVariable userId: Long, @PathVariable workDate: LocalDate): ResponseEntity<Any> {
        val userPersonalSchedule: UserPersonalSchedule? = userPersonalScheduleService.findByUserIdAndDate(userId, workDate)
        userPersonalSchedule?.let {
            return ResponseEntity(userPersonalSchedule, OK)
        }
        throw NotFoundException("User personal schedule did not find by user id and work date")
    }

}