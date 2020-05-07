package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.PersonalSchedule
import java.util.*


interface PersonalScheduleService {

    fun save(personalSchedule: PersonalSchedule): PersonalSchedule

    fun findById(id: Long): Optional<PersonalSchedule>

    fun findAll(): List<PersonalSchedule>

    fun update(personalSchedule: PersonalSchedule): PersonalSchedule

}