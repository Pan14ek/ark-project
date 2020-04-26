package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.Unit
import ua.nure.makieiev.ark.repository.UnitRepository
import ua.nure.makieiev.ark.service.UnitService

@Service
class UnitServiceImpl @Autowired constructor(var unitRepository: UnitRepository) : UnitService {

    override fun save(unit: Unit): Unit {
        TODO("Not yet implemented")
    }

    override fun findByTitle(title: String): Unit {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Unit {
        TODO("Not yet implemented")
    }

}