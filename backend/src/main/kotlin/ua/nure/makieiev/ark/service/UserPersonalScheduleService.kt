package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.UserPersonalSchedule
import java.time.LocalDate
import java.util.*

interface UserPersonalScheduleService {

    fun save(userPersonalSchedule: UserPersonalSchedule): UserPersonalSchedule

    fun findByUserIdAndDate(userId: Long, workDate: LocalDate): UserPersonalSchedule

    fun findAllByUserId(userId: Long): List<UserPersonalSchedule>

    fun findById(id: Long): Optional<UserPersonalSchedule>

    fun confirmPersonalSchedule(confirmFlag: Boolean, userPersonalSchedule: UserPersonalSchedule): UserPersonalSchedule

    fun update(userPersonalSchedule: UserPersonalSchedule): UserPersonalSchedule

}