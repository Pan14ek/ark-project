package ua.nure.makieiev.ark.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
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
import ua.nure.makieiev.ark.exception.NotUniqueRoleFieldException
import ua.nure.makieiev.ark.exception.response.ConflictException
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.dto.RoleDto
import ua.nure.makieiev.ark.model.entity.Role
import ua.nure.makieiev.ark.service.RoleService
import ua.nure.makieiev.ark.util.converter.impl.RoleConverter
import javax.validation.Valid

@RestController
@RequestMapping("/role")
class RoleController @Autowired constructor(private val roleService: RoleService,
                                            private val roleConverter: RoleConverter) {

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/add"], produces = ["application/json"])
    fun addRole(@RequestBody @Valid roleDto: RoleDto, bindingResult: BindingResult): ResponseEntity<Any> {
        try {
            return if (bindingResult.hasErrors()) {
                ResponseEntity(bindingResult, HttpStatus.BAD_REQUEST)
            } else {
                val role = roleConverter.fill(roleDto)
                ResponseEntity(roleService.save(role), HttpStatus.CREATED)
            }
        } catch (exception: NotUniqueRoleFieldException) {
            throw ConflictException(exception.message)
        }
    }

    @PreAuthorize("hasRole('Administration')")
    @GetMapping("/title/{title}")
    fun findByTitle(@PathVariable title: String): ResponseEntity<Any> {
        val role: Role? = roleService.findByTitle(title)
        role?.let {
            return ResponseEntity(role, OK)
        }
        throw NotFoundException("Role did not find by title")
    }

    @PreAuthorize("hasRole('Administration')")
    @GetMapping("/symbol/{symbol}")
    fun findBySymbol(@PathVariable symbol: String): ResponseEntity<Any> {
        val role: Role? = roleService.findBySymbol(symbol)
        role?.let {
            return ResponseEntity(role, OK)
        }
        throw NotFoundException("Role did not find by symbol")
    }

    @PreAuthorize("hasRole('Administration')")
    @PostMapping(value = ["/update"], produces = ["application/json"])
    fun updateRole(@RequestBody @Valid roleDto: RoleDto, bindingResult: BindingResult): ResponseEntity<Any> {
        try {
            return if (bindingResult.hasErrors()) {
                ResponseEntity(bindingResult, HttpStatus.BAD_REQUEST)
            } else {
                val role = roleConverter.fill(roleDto)
                ResponseEntity(roleService.update(role), OK)
            }
        } catch (exception: NotUniqueRoleFieldException) {
            throw ConflictException(exception.message)
        }
    }

    @PreAuthorize("hasRole('Administration')")
    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<Role>> {
        return ResponseEntity(roleService.findAll(), OK)
    }

}