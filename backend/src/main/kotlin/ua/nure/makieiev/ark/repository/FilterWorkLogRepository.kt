package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.FilterWorkLog

@Repository
interface FilterWorkLogRepository : CrudRepository<FilterWorkLog, Long> {

    fun findAllByFilterUnitId(filterUnitId: Long): List<FilterWorkLog>

}