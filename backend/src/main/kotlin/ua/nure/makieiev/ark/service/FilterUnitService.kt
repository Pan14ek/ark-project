package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.FilterUnit
import java.util.*

interface FilterUnitService {

    fun save(filterUnit: FilterUnit): FilterUnit

    fun findById(id: Long): Optional<FilterUnit>

    fun findByUnitIdAndStatus(unitId: Long, status: String): FilterUnit

    fun findAll(): List<FilterUnit>

}