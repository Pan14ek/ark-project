package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.exception.IllegalWorkException
import ua.nure.makieiev.ark.exception.response.NotFoundException
import ua.nure.makieiev.ark.model.entity.PointConfig
import ua.nure.makieiev.ark.model.entity.WorkLog
import ua.nure.makieiev.ark.repository.PointConfigRepository
import ua.nure.makieiev.ark.repository.UserPersonalScheduleRepository
import ua.nure.makieiev.ark.repository.WorkLogRepository
import ua.nure.makieiev.ark.service.WorkLogService
import java.time.LocalDate
import java.util.*

@Service
class WorkLogServiceImpl @Autowired constructor(private val workLogRepository: WorkLogRepository,
                                                private val pointConfigRepository: PointConfigRepository,
                                                private val userPersonalScheduleRepository: UserPersonalScheduleRepository) : WorkLogService {

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
        val userId: Long? = workLog.user!!.id
        val pointConfig = obtainPointConfig()
        val particularWorkLog = workLogRepository.findByUserIdAndWorkDate(userId!!, workLog.workDate!!)
        checkParticularWorkLog(particularWorkLog)
        val userPersonalSchedule = userPersonalScheduleRepository.findByUserIdAndWorkDate(userId, workLog.workDate!!)
        if (Objects.nonNull(userPersonalSchedule)) {
            workLog.amountPoints = pointConfig.defaultPoints
        } else {
            workLog.amountPoints = pointConfig.extraPoints
        }
        return workLogRepository.save(workLog)
    }

    private fun obtainPointConfig(): PointConfig {
        val pointConfigOptional = pointConfigRepository.findById(DEFAULT_POINT_CONFIG)
        if (pointConfigOptional.isPresent) {
            return pointConfigOptional.get()
        } else {
            throw NotFoundException("Point config did not find by id")
        }
    }

    private fun checkParticularWorkLog(particularWorkLog: WorkLog) {
        if (Objects.nonNull(particularWorkLog)) {
            throw IllegalWorkException("You marked today")
        }
    }

    companion object {
        const val DEFAULT_POINT_CONFIG: Long = 1
    }

}