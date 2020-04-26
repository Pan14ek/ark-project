package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.WorkLog
import ua.nure.makieiev.ark.repository.WorkLogRepository
import ua.nure.makieiev.ark.service.WorkLogService

@Service
class WorkLogServiceImpl @Autowired constructor(workLogRepository: WorkLogRepository) : WorkLogService {

    override fun findById(id: Long): WorkLog {
        TODO("Not yet implemented")
    }

    override fun findByUserId(userId: Long): WorkLog {
        TODO("Not yet implemented")
    }

    override fun findAllByUserId(userId: Long): List<WorkLog> {
        TODO("Not yet implemented")
    }

    override fun findAllInParticularMonthByUserId(userId: Long): List<WorkLog> {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<WorkLog> {
        TODO("Not yet implemented")
    }

    override fun save(workLog: WorkLog): WorkLog {
        TODO("Not yet implemented")
    }

}