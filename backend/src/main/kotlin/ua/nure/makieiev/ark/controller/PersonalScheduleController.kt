package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.BAD_REQUEST
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
import ua.nure.makieiev.ark.model.dto.PersonalScheduleDto
import ua.nure.makieiev.ark.model.entity.PersonalSchedule
import ua.nure.makieiev.ark.service.PersonalScheduleService
import javax.validation.Valid

@RestController
@RequestMapping("/personal/schedule")
class PersonalScheduleController @Autowired constructor(private val personalScheduleService: PersonalScheduleService) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addPersonalSchedule(@RequestBody @Valid personalScheduleDto: PersonalScheduleDto,
                            bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val personalSchedule = PersonalSchedule()
            personalSchedule.amountDays = personalScheduleDto.amountDays
            ResponseEntity(personalScheduleService.save(personalSchedule), OK)
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val personalScheduleOptional = personalScheduleService.findById(id)
        if (personalScheduleOptional.isPresent) {
            return ResponseEntity(personalScheduleOptional.get(), OK)
        }
        throw NotFoundException("Personal schedule did not find by id")
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/all")
    fun findAll(): ResponseEntity<Any> {
        return ResponseEntity(personalScheduleService.findAll(), OK)
    }

}