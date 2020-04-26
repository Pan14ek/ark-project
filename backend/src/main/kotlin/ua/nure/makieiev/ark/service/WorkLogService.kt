package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.WorkLog

interface WorkLogService {

    fun findById(id: Long): WorkLog
    fun findByUserId(userId: Long): WorkLog
    fun findAllByUserId(userId: Long): List<WorkLog>
    fun findAllInParticularMonthByUserId(userId: Long): List<WorkLog>
    fun findAll(): List<WorkLog>
    fun save(workLog: WorkLog): WorkLog

}