package ua.nure.makieiev.ark.util.converter

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.UnitDto
import ua.nure.makieiev.ark.model.entity.Unit

@Component
class UnitConverter {

    fun fillUnit(unitDto: UnitDto): Unit {
        val unit = Unit()
        unit.title = unitDto.title
        unit.description = unitDto.description
        unit.status = unitDto.status
        return unit
    }

}