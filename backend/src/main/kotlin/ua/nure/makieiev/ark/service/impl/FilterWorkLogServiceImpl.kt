package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.FilterWorkLog
import ua.nure.makieiev.ark.repository.FilterWorkLogRepository
import ua.nure.makieiev.ark.service.FilterWorkLogService
import java.util.*

@Service
class FilterWorkLogServiceImpl @Autowired constructor(private val filterWorkLogRepository: FilterWorkLogRepository) : FilterWorkLogService {

    override fun save(filterWorkLog: FilterWorkLog): FilterWorkLog {
        return filterWorkLogRepository.save(filterWorkLog)
    }

    override fun findById(id: Long): Optional<FilterWorkLog> {
        return filterWorkLogRepository.findById(id)
    }

    override fun findAll(): List<FilterWorkLog> {
        return filterWorkLogRepository.findAll() as MutableList
    }

    override fun findAllByFilterUnitId(filterUnitId: Long): List<FilterWorkLog> {
        return filterWorkLogRepository.findAllByFilterUnitId(filterUnitId)
    }

}