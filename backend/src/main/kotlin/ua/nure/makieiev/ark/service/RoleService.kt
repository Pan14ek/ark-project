package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.Role

interface RoleService {

    fun findByTitle(title: String): Role

    fun findBySymbol(symbol: String): Role

    fun save(role: Role): Role

}