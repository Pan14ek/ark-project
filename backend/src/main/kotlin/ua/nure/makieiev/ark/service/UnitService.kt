package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.Unit

interface UnitService {

    fun save(unit: Unit): Unit
    fun findByTitle(title: String): Unit
    fun findById(id: Long): Unit

}