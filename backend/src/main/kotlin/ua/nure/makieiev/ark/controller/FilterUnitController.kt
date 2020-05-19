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
import ua.nure.makieiev.ark.model.dto.FilterUnitDto
import ua.nure.makieiev.ark.model.entity.FilterUnit
import ua.nure.makieiev.ark.service.FilterService
import ua.nure.makieiev.ark.service.FilterUnitService
import ua.nure.makieiev.ark.service.UnitService
import javax.validation.Valid

@RestController
@RequestMapping("/filter/unit")
class FilterUnitController @Autowired constructor(private val filterUnitService: FilterUnitService,
                                                  private val unitService: UnitService,
                                                  private val filterService: FilterService) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addFilterUnit(@RequestBody @Valid filterUnitDto: FilterUnitDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val filterUnit = obtainFilterUnit(filterUnitDto)
            ResponseEntity(filterUnitService.save(filterUnit), CREATED)
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val filterUnitOptional = filterUnitService.findById(id)
        if (filterUnitOptional.isPresent) {
            return ResponseEntity(filterUnitOptional.get(), OK)
        }
        throw NotFoundException("Filter from unit did not find by id")
    }

    private fun obtainFilterUnit(filterUnitDto: FilterUnitDto): FilterUnit {
        val filterUnit = FilterUnit()
        val unitOptional = filterUnitDto.unitId?.let { unitService.findById(it) }
        val filterOptional = filterUnitDto.filterId?.let { filterService.findById(it) }
        if (unitOptional!!.isPresent && filterOptional!!.isPresent) {
            filterUnit.status = filterUnitDto.status
            filterUnit.filter = filterOptional.get()
            filterUnit.unit = unitOptional.get()
            filterUnit.dateInstall = filterUnitDto.dateInstall
            filterUnit.dateRemoval = filterUnitDto.dateRemoval
        }
        return filterUnit
    }

}