package ua.nure.makieiev.ark.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.FilterWorkLog

@Repository
interface FilterWorkLogRepository : CrudRepository<FilterWorkLog, Long> {

    fun findAllByFilterUnitId(filterUnitId: Long): List<FilterWorkLog>

    @Query(value = "SELECT CAST(round(AVG(CAST(fwl.temperature AS NUMERIC))) AS VARCHAR) as temperature, SUM(fwl.filter_contamination) as filter_contamination, fwl.scan_date_time FROM filter_work_log fwl group by fwl.scan_date_time order by fwl.scan_date_time", nativeQuery = true)
    fun getStatisticByFilerWorkLog(): List<FilterWorkLog>

}