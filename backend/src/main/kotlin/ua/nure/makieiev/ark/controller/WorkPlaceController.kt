package ua.nure.makieiev.ark.controller

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
import ua.nure.makieiev.ark.model.dto.WorkPlaceDto
import ua.nure.makieiev.ark.model.entity.WorkPlace
import ua.nure.makieiev.ark.service.UnitService
import ua.nure.makieiev.ark.service.WorkPlaceService
import javax.validation.Valid

@RestController
@RequestMapping("/workplace")
class WorkPlaceController constructor(private val workPlaceService: WorkPlaceService, private val unitService: UnitService) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addWorkPlace(@RequestBody @Valid workPlaceDto: WorkPlaceDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val workPlace = obtainWorkPlace(workPlaceDto)
            ResponseEntity(workPlaceService.save(workPlace), CREATED)
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/all")
    fun findAll(): ResponseEntity<Any> {
        return ResponseEntity(workPlaceService.findAll(), OK)
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val workPlaceOptional = workPlaceService.findById(id)
        if (workPlaceOptional.isPresent) {
            return ResponseEntity(workPlaceOptional.get(), OK)
        }
        throw NotFoundException("Work place did not find by id")
    }

    private fun obtainWorkPlace(workPlaceDto: WorkPlaceDto): WorkPlace {
        val workPlace = WorkPlace()
        val unitOptional = workPlaceDto.unitId?.let { unitService.findById(it) }
        if (unitOptional!!.isPresent) {
            workPlace.title = workPlaceDto.title
            workPlace.size = workPlaceDto.size
            workPlace.unit = unitOptional.get()
        }
        return workPlace
    }

}