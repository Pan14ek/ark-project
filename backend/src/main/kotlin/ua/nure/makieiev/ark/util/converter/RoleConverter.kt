package ua.nure.makieiev.ark.util.converter

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.RoleDto
import ua.nure.makieiev.ark.model.entity.Role

@Component
class RoleConverter {

    fun fillRole(roleDto: RoleDto): Role {
        val role = Role()
        role.title = roleDto.title
        role.symbol = roleDto.symbol
        role.description = roleDto.description
        return role
    }

}