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
import ua.nure.makieiev.ark.model.dto.FilterChemicalSubstancesDto
import ua.nure.makieiev.ark.model.entity.FilterChemicalSubstances
import ua.nure.makieiev.ark.service.ChemicalSubstanceService
import ua.nure.makieiev.ark.service.FilterChemicalSubstancesService
import ua.nure.makieiev.ark.service.FilterService
import javax.validation.Valid

@RestController
@RequestMapping("/filter/chemical/substances")
class FilterChemicalSubstancesController @Autowired constructor(private val filterChemicalSubstancesService: FilterChemicalSubstancesService,
                                                                private val filterService: FilterService,
                                                                private val chemicalSubstanceService: ChemicalSubstanceService) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addFilterChemicalSubstances(@RequestBody @Valid filterChemicalSubstancesDto: FilterChemicalSubstancesDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val filterChemicalSubstance = FilterChemicalSubstances()
            val chemicalSubstanceOptional = chemicalSubstanceService.findById(filterChemicalSubstancesDto.chemicalSubstanceId)
            val filterOptional = filterService.findById(filterChemicalSubstancesDto.filterId)
            if (chemicalSubstanceOptional.isPresent && filterOptional.isPresent) {
                filterChemicalSubstance.chemicalSubstance = chemicalSubstanceOptional.get()
                filterChemicalSubstance.filter = filterOptional.get()
            }
            ResponseEntity(filterChemicalSubstancesService.save(filterChemicalSubstance), CREATED)
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val filterChemicalSubstancesOptional = filterChemicalSubstancesService.findById(id)
        if (filterChemicalSubstancesOptional.isPresent) {
            return ResponseEntity(filterChemicalSubstancesOptional.get(), OK)
        }
        throw NotFoundException("Filter chemical substance did not find by id")
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/all/filterId/{filterId}")
    fun findAllByFilterID(@PathVariable filterId: Long): ResponseEntity<Any> {
        val filterChemicalSubstances: List<FilterChemicalSubstances>? = filterChemicalSubstancesService.findAllByFilterId(filterId)
        filterChemicalSubstances?.let { return ResponseEntity(filterChemicalSubstances, OK) }
        throw NotFoundException("Filter chemical substance did not find by filter id")
    }

}