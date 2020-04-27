package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.PersonalSchedule
import ua.nure.makieiev.ark.repository.PersonalScheduleRepository
import ua.nure.makieiev.ark.service.PersonalScheduleService
import java.util.*

@Service
class PersonalScheduleServiceImpl @Autowired constructor(private val personalScheduleRepository: PersonalScheduleRepository) : PersonalScheduleService {

    override fun save(personalSchedule: PersonalSchedule): PersonalSchedule {
        return personalScheduleRepository.save(personalSchedule)
    }

    override fun findById(id: Long): Optional<PersonalSchedule> {
        return personalScheduleRepository.findById(id)
    }

    override fun findAll(): List<PersonalSchedule> {
        return personalScheduleRepository.findAll().toMutableList()
    }

}