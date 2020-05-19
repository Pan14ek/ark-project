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
import ua.nure.makieiev.ark.model.dto.ChemicalSubstanceDto
import ua.nure.makieiev.ark.service.ChemicalSubstanceService
import ua.nure.makieiev.ark.util.converter.impl.ChemicalSubstanceConverter
import javax.validation.Valid

@RestController
@RequestMapping("/chemical/substance")
class ChemicalSubstanceController constructor(private val chemicalSubstanceService: ChemicalSubstanceService,
                                              private val chemicalSubstanceConverter: ChemicalSubstanceConverter) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addChemicalSubstance(@RequestBody @Valid chemicalSubstanceDto: ChemicalSubstanceDto,
                             bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val chemicalSubstance = chemicalSubstanceConverter.fill(chemicalSubstanceDto)
            ResponseEntity(chemicalSubstanceService.save(chemicalSubstance), CREATED)
        }
    }

    @PreAuthorize("hasRole('Administration')")
    @GetMapping("/all")
    fun findAll(): ResponseEntity<Any> {
        return ResponseEntity(chemicalSubstanceService.findAll(), OK)
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val chemicalSubstanceOptional = chemicalSubstanceService.findById(id)
        if (chemicalSubstanceOptional.isPresent) {
            return ResponseEntity(chemicalSubstanceOptional.get(), OK)
        }
        throw NotFoundException("Chemical substance did not find by id")
    }

}