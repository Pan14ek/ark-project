package ua.nure.makieiev.ark.util.converter.impl

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.UnitDto
import ua.nure.makieiev.ark.model.entity.Unit
import ua.nure.makieiev.ark.util.converter.Converter

@Component
class UnitConverter : Converter<UnitDto, Unit> {

    override fun fill(any: UnitDto): Unit {
        val unit = Unit()
        unit.title = any.title
        unit.description = any.description
        unit.status = any.status
        return unit
    }

}