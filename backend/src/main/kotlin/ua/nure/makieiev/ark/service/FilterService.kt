package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.Filter
import java.util.*

interface FilterService {

    fun save(filter: Filter): Filter

    fun updateFilter(filter: Filter): Boolean

    fun findById(id: Long): Optional<Filter>

    fun findByTitle(title: String): Filter

    fun findAll(): List<Filter>

}