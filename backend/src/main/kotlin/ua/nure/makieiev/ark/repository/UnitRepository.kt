package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.Unit

@Repository
interface UnitRepository : CrudRepository<Unit, Long> {

    fun findByTitle(title: String): Unit

}