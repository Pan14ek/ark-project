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
import ua.nure.makieiev.ark.exception.NotUniqueUnitFieldException
import ua.nure.makieiev.ark.exception.response.ConflictException
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.dto.UnitDto
import ua.nure.makieiev.ark.model.entity.Unit
import ua.nure.makieiev.ark.service.UnitService
import ua.nure.makieiev.ark.util.converter.UnitConverter
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/unit")
class UnitController @Autowired constructor(var unitService: UnitService,
                                            var unitConverter: UnitConverter) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addUnit(@RequestBody @Valid unitDto: UnitDto, bindingResult: BindingResult): ResponseEntity<Any> {
        try {
            return if (bindingResult.hasErrors()) {
                ResponseEntity(bindingResult, BAD_REQUEST)
            } else {
                val unit: Unit = unitConverter.fillUnit(unitDto)
                ResponseEntity(unitService.save(unit), CREATED)
            }
        } catch (exception: NotUniqueUnitFieldException) {
            throw ConflictException(exception.message)
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/title/{title}")
    fun findByTitle(@PathVariable title: String): ResponseEntity<Any> {
        val unit: Unit? = unitService.findByTitle(title)
        unit?.let { return ResponseEntity(unit, OK) }
        throw NotFoundException("Unit did not find by title")
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val unit: Optional<Unit> = unitService.findById(id)
        if (unit.isPresent) {
            return ResponseEntity(unit.get(), OK)
        }
        throw NotFoundException("Unit did not find by id")
    }

}