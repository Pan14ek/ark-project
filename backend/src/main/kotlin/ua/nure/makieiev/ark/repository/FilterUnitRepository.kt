package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.FilterUnit

@Repository
interface FilterUnitRepository : CrudRepository<FilterUnit, Long> {

    fun findByUnitIdAndStatus(unitId: Long, status: String): FilterUnit

}