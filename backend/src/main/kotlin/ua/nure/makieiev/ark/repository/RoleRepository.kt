package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.Role

@Repository
interface RoleRepository : CrudRepository<Role, Long> {

    fun findByTitle(title: String): Role

    fun findBySymbol(symbol: String): Role

}