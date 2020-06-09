package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.FilterWorkLog
import ua.nure.makieiev.ark.model.entity.FilterWorkLogStatistic
import java.util.*

interface FilterWorkLogService {

    fun save(filterWorkLog: FilterWorkLog): FilterWorkLog

    fun findById(id: Long): Optional<FilterWorkLog>

    fun findAll(): List<FilterWorkLog>

    fun findAllByFilterUnitId(filterUnitId: Long): List<FilterWorkLog>

    fun getStatisticByFilerWorkLog(): List<FilterWorkLogStatistic>

}