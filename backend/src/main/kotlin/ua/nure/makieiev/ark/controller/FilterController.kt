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
import ua.nure.makieiev.ark.model.dto.FilterDto
import ua.nure.makieiev.ark.model.entity.Filter
import ua.nure.makieiev.ark.service.FilterService
import ua.nure.makieiev.ark.util.converter.impl.FilterConverter
import javax.validation.Valid

@RestController
@RequestMapping("/filter")
class FilterController @Autowired constructor(private val filterConverter: FilterConverter,
                                              private val filterService: FilterService) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addFilter(@RequestBody @Valid filterDto: FilterDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val filter = filterConverter.fill(filterDto)
            ResponseEntity(filterService.save(filter), CREATED)
        }
    }

    @PreAuthorize("hasRole('Administration')")
    @GetMapping("/all")
    fun findAll(): ResponseEntity<Any> {
        return ResponseEntity(filterService.findAll(), OK)
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val filterOptional = filterService.findById(id)
        if (filterOptional.isPresent) {
            return ResponseEntity(filterOptional.get(), OK)
        }
        throw NotFoundException("Filter did not find by id")
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("title/{title}")
    fun findByTitle(@PathVariable title: String): ResponseEntity<Any> {
        val filter: Filter? = filterService.findByTitle(title)
        filter?.let { return ResponseEntity(filter, OK) }
        throw NotFoundException("Filter did not find by id")
    }

}