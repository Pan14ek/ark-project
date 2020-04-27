package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.nure.makieiev.ark.exception.IllegalWorkException
import ua.nure.makieiev.ark.exception.response.ConflictException
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.dto.WorkLogDto
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.model.entity.WorkLog
import ua.nure.makieiev.ark.service.UserService
import ua.nure.makieiev.ark.service.WorkLogService
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/worklog")
class WorkLogController @Autowired constructor(var workLogService: WorkLogService,
                                               var userService: UserService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        val workLogOptional: Optional<WorkLog> = workLogService.findById(id)
        if (workLogOptional.isPresent) {
            return ResponseEntity(workLogOptional.get(), OK)
        }
        throw NotFoundException("Work log did not find by id")
    }

    @GetMapping("/all")
    fun findAll(): ResponseEntity<Any> {
        val workLogs: List<WorkLog> = workLogService.findAll()
        return ResponseEntity(workLogs, OK)
    }

    @GetMapping("/all/user/{id}")
    fun findAllByUserId(@PathVariable id: Long): ResponseEntity<Any> {
        val workLogs: List<WorkLog> = workLogService.findAllByUserId(id)
        return ResponseEntity(workLogs, OK)
    }

    @GetMapping("/user/{id}")
    fun findByUserId(@PathVariable id: Long): ResponseEntity<Any> {
        val workLog: WorkLog? = workLogService.findByUserId(id)
        workLog?.let { return ResponseEntity(workLog, OK) }
        throw NotFoundException("Work log did not find by user id")
    }

    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addUserToWorkLog(@RequestBody @Valid workLogDto: WorkLogDto,
                         bindingResult: BindingResult): ResponseEntity<Any> {
        try {
            return if (bindingResult.hasErrors()) {
                ResponseEntity(bindingResult, BAD_REQUEST)
            } else {
                val user: User? = userService.findByLogin(workLogDto.userLogin!!)
                val workLog = WorkLog()
                workLog.user = user
                workLog.workDate = workLogDto.workDate
                ResponseEntity(workLogService.save(workLog), CREATED)
            }
        } catch (exception: IllegalWorkException) {
            throw ConflictException(exception.message)
        }
    }

}