package ua.nure.makieiev.ark.util.converter.impl

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.RoleDto
import ua.nure.makieiev.ark.model.entity.Role
import ua.nure.makieiev.ark.util.converter.Converter

@Component
class RoleConverter : Converter<RoleDto, Role> {

    override fun fill(any: RoleDto): Role {
        val role = Role()
        role.title = any.title
        role.symbol = any.symbol
        role.description = any.description
        return role
    }

}