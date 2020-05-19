package ua.nure.makieiev.ark.util.converter.impl

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.PointConfigDto
import ua.nure.makieiev.ark.model.entity.PointConfig
import ua.nure.makieiev.ark.util.converter.Converter

@Component
class PointConfigConverter : Converter<PointConfigDto, PointConfig> {

    override fun fill(any: PointConfigDto): PointConfig {
        val pointConfig = PointConfig()
        pointConfig.defaultPoints = any.defaultPoints
        pointConfig.extraPoints = any.extraPoints
        return pointConfig
    }

}