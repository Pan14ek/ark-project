package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.WorkLog
import java.time.LocalDate

@Repository
interface WorkLogRepository : CrudRepository<WorkLog, Long> {

    fun findByUserId(userId: Long): WorkLog

    fun findAllByUserId(userId: Long): List<WorkLog>

    fun findByUserIdAndWorkDate(userId: Long, workDate: LocalDate): WorkLog

}