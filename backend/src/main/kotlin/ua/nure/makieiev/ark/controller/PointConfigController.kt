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
import ua.nure.makieiev.ark.model.dto.PointConfigDto
import ua.nure.makieiev.ark.model.entity.PointConfig
import ua.nure.makieiev.ark.service.PointConfigService
import ua.nure.makieiev.ark.util.converter.impl.PointConfigConverter
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/point/config")
class PointConfigController @Autowired constructor(private val pointConfigService: PointConfigService,
                                                   private val pointConfigConverter: PointConfigConverter) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addPointConfig(@RequestBody @Valid pointConfigDto: PointConfigDto,
                       bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val pointConfig: PointConfig = pointConfigConverter.fill(pointConfigDto)
            ResponseEntity(pointConfigService.save(pointConfig), CREATED)
        }
    }

    @PreAuthorize("hasRole('Administration')")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val pointConfigOptional: Optional<PointConfig> = pointConfigService.findById(id)
        if (pointConfigOptional.isPresent) {
            return ResponseEntity(pointConfigOptional.get(), OK)
        }
        throw NotFoundException("Point config did not find by id")
    }

}