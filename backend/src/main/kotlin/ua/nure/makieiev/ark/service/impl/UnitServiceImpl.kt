package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.exception.NotUniqueUnitFieldException
import ua.nure.makieiev.ark.model.entity.Unit
import ua.nure.makieiev.ark.repository.UnitRepository
import ua.nure.makieiev.ark.service.UnitService
import java.util.*

@Service
class UnitServiceImpl @Autowired constructor(var unitRepository: UnitRepository) : UnitService {

    override fun save(unit: Unit): Unit {
        try {
            return unitRepository.save(unit)
        } catch (exception: DataIntegrityViolationException) {
            throw NotUniqueUnitFieldException("The database contains a unit field with this information",
                    exception, enableSuppression = true, writableStackTrace = true)
        }
    }

    override fun findByTitle(title: String): Unit {
        return unitRepository.findByTitle(title)
    }

    override fun findById(id: Long): Optional<Unit> {
        return unitRepository.findById(id)
    }

}