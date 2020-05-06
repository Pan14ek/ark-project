package ua.nure.makieiev.ark.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.UserPersonalSchedule
import java.time.LocalDate

@Repository
interface UserPersonalScheduleRepository : CrudRepository<UserPersonalSchedule, Long> {

    @Query(value = "SELECT Id_personal_schedule, Id_user, Work_date, Confirm FROM users_personal_schedules ups WHERE ups.Id_user=?1 AND ups.Work_date=?2", nativeQuery = true)
    fun findByUserIdAndWorkDate(userId: Long, workDate: LocalDate): UserPersonalSchedule

    fun findAllByUserId(userId: Long): List<UserPersonalSchedule>

    @Query(value = "INSERT into users_personal_schedules (Id_personal_schedule, Id_user, Work_date, Confirm) values (?1,?2,?3,?4)", nativeQuery = true)
    fun add(idPersonalSchedule: Long, userId: Long, workDate: LocalDate, confirm: Boolean)

}