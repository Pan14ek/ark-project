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
import ua.nure.makieiev.ark.model.dto.FilterWorkLogDto
import ua.nure.makieiev.ark.model.entity.FilterWorkLog
import ua.nure.makieiev.ark.service.FilterUnitService
import ua.nure.makieiev.ark.service.FilterWorkLogService
import javax.validation.Valid

@RestController
@RequestMapping("/filter/worklog")
class FilterWorkLogController @Autowired constructor(private val filterUnitService: FilterUnitService,
                                                     private val filterWorkLogService: FilterWorkLogService) {

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addFilterWorkLog(@RequestBody @Valid filterWorkLogDto: FilterWorkLogDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return if (bindingResult.hasErrors()) {
            ResponseEntity(bindingResult, BAD_REQUEST)
        } else {
            val filterWorkLog = obtainFilterWorkLog(filterWorkLogDto)
            ResponseEntity(filterWorkLogService.save(filterWorkLog), CREATED)
        }
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/all")
    fun findAll(): ResponseEntity<Any> {
        return ResponseEntity(filterWorkLogService.findAll(), OK)
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("unit/{unitId}")
    fun findAllFilterWorkLogByUnitId(@PathVariable unitId: Long): ResponseEntity<Any> {
        return ResponseEntity(filterWorkLogService.findAllByFilterUnitId(unitId), OK)
    }

    fun obtainFilterWorkLog(filterWorkLogDto: FilterWorkLogDto): FilterWorkLog {
        val filterWorkLog = FilterWorkLog()
        val filterUnitOptional = filterWorkLogDto.filterUnitId?.let { filterUnitService.findById(it) }
        if (filterUnitOptional!!.isPresent) {
            filterWorkLog.filterUnit = filterUnitOptional.get()
            filterWorkLog.filterContamination = filterWorkLogDto.filterContamination
            filterWorkLog.temperature = filterWorkLogDto.temperature
            filterWorkLog.scanDateTime = filterWorkLogDto.scanDateTime
        }
        return filterWorkLog
    }

    @PreAuthorize("hasAnyRole('RegisteredUser', 'Administration')")
    @GetMapping("/statistic")
    fun getStatistic(): ResponseEntity<Any> {
        return ResponseEntity(filterWorkLogService.getStatisticByFilerWorkLog(), OK)
    }

}