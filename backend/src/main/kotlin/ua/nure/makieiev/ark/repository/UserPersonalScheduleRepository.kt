package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.UserPersonalSchedule
import java.time.LocalDate

@Repository
interface UserPersonalScheduleRepository : CrudRepository<UserPersonalSchedule, Long> {

    fun findByUserIdAndWorkDate(userId: Long, workDate: LocalDate): UserPersonalSchedule

    fun findAllByUserId(userId: Long): List<UserPersonalSchedule>

}