package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.FilterUnit
import ua.nure.makieiev.ark.repository.FilterUnitRepository
import ua.nure.makieiev.ark.service.FilterUnitService
import java.util.*

@Service
class FilterUnitServiceImpl @Autowired constructor(private val filterUnitRepository: FilterUnitRepository) : FilterUnitService {

    override fun save(filterUnit: FilterUnit): FilterUnit {
        return filterUnitRepository.save(filterUnit)
    }

    override fun findById(id: Long): Optional<FilterUnit> {
        return filterUnitRepository.findById(id)
    }

    override fun findByUnitIdAndStatus(unitId: Long, status: String): FilterUnit {
        return filterUnitRepository.findByUnitIdAndStatus(unitId, status)
    }

    override fun findAll(): List<FilterUnit> {
        return filterUnitRepository.findAll() as MutableList
    }

}