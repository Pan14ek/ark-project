package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.WorkLog
import java.time.LocalDate
import java.util.*

interface WorkLogService {

    fun findById(id: Long): Optional<WorkLog>

    fun findByUserIdAndDate(userId: Long, workDate: LocalDate): WorkLog

    fun findAllByUserId(userId: Long): List<WorkLog>

    fun findAllInSameMonthByUserId(userId: Long): List<WorkLog>

    fun findAll(): List<WorkLog>

    fun save(workLog: WorkLog): WorkLog

}