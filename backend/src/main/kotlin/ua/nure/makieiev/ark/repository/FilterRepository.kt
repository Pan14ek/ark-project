package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.Filter

@Repository
interface FilterRepository : CrudRepository<Filter, Long> {

    fun findByTitle(title: String): Filter

}