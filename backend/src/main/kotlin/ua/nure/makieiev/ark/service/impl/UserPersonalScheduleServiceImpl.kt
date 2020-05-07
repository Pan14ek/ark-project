package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.UserPersonalSchedule
import ua.nure.makieiev.ark.repository.UserPersonalScheduleRepository
import ua.nure.makieiev.ark.service.UserPersonalScheduleService
import java.time.LocalDate
import java.util.*

@Service
class UserPersonalScheduleServiceImpl @Autowired constructor(private val userPersonalScheduleRepository: UserPersonalScheduleRepository) : UserPersonalScheduleService {

    override fun save(userPersonalSchedule: UserPersonalSchedule): UserPersonalSchedule {
        userPersonalScheduleRepository.add(userPersonalSchedule.personalSchedule!!.id!!, userPersonalSchedule.user!!.id!!, userPersonalSchedule.workDate!!, userPersonalSchedule.confirm!!)
        return findByUserIdAndDate(userPersonalSchedule.user!!.id!!, userPersonalSchedule.workDate!!)
    }

    override fun findByUserIdAndDate(userId: Long, workDate: LocalDate): UserPersonalSchedule {
        return userPersonalScheduleRepository.findByUserIdAndWorkDate(userId, workDate)
    }

    override fun findAllByUserId(userId: Long): List<UserPersonalSchedule> {
        return userPersonalScheduleRepository.findAllByUserId(userId)
    }

    override fun findById(id: Long): Optional<UserPersonalSchedule> {
        return userPersonalScheduleRepository.findById(id)
    }

    override fun confirmPersonalSchedule(confirmFlag: Boolean, userPersonalSchedule: UserPersonalSchedule): UserPersonalSchedule {
        userPersonalSchedule.confirm = confirmFlag
        return userPersonalScheduleRepository.save(userPersonalSchedule)
    }

    override fun update(userPersonalSchedule: UserPersonalSchedule): UserPersonalSchedule {
        return save(userPersonalSchedule)
    }

}