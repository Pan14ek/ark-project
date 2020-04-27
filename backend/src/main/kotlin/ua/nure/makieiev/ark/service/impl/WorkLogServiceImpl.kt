package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.exception.IllegalWorkException
import ua.nure.makieiev.ark.model.entity.WorkLog
import ua.nure.makieiev.ark.repository.PointConfigRepository
import ua.nure.makieiev.ark.repository.WorkLogRepository
import ua.nure.makieiev.ark.service.WorkLogService
import java.time.LocalDate
import java.util.*

@Service
class WorkLogServiceImpl @Autowired constructor(var workLogRepository: WorkLogRepository,
                                                var pointConfigRepository: PointConfigRepository) : WorkLogService {

    override fun findById(id: Long): Optional<WorkLog> {
        return workLogRepository.findById(id)
    }

    override fun findByUserId(userId: Long): WorkLog {
        return workLogRepository.findByUserId(userId)
    }

    override fun findAllByUserId(userId: Long): List<WorkLog> {
        return workLogRepository.findAllByUserId(userId)
    }

    override fun findAllInSameMonthByUserId(userId: Long): List<WorkLog> {
        val allUserWorkLog: List<WorkLog> = findAllByUserId(userId)
        val nowDate: LocalDate = LocalDate.now()
        return allUserWorkLog.filter { workLog -> workLog.workDate!!.monthValue == nowDate.monthValue }
    }

    override fun findAll(): List<WorkLog> {
        return workLogRepository.findAll().toMutableList()
    }

    override fun save(workLog: WorkLog): WorkLog {
        try {
            val userId: Long? = workLog.user?.id
            val particularWorkLog: WorkLog? = workLog.workDate?.let { workLogRepository.findByUserIdAndWorkDate(userId!!, it) }
            throw IllegalWorkException("You marked today")
        } catch (exception: EmptyResultDataAccessException) {
            val pointConfigOptional = pointConfigRepository.findById(DEFAULT_POINT_CONFIG)
            if (pointConfigOptional.isPresent) {
                val pointConfig = pointConfigOptional.get()
                workLog.amountPoints = pointConfig.defaultPoints
            }
            return workLogRepository.save(workLog)
        }
    }

    companion object {
        const val DEFAULT_POINT_CONFIG: Long = 1
    }

}