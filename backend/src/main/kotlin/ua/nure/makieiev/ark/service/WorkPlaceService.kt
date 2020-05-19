package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.WorkPlace
import java.util.*

interface WorkPlaceService {

    fun save(workPlace: WorkPlace): WorkPlace

    fun findById(id: Long): Optional<WorkPlace>

    fun findAll(): List<WorkPlace>

}