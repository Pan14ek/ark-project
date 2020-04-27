package ua.nure.makieiev.ark.util.converter

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.PointConfigDto
import ua.nure.makieiev.ark.model.entity.PointConfig

@Component
class PointConfigConverter {

    fun fillPointConfig(pointConfigDto: PointConfigDto): PointConfig {
        val pointConfig = PointConfig()
        pointConfig.defaultPoints = pointConfigDto.defaultPoints
        pointConfig.extraPoints = pointConfigDto.extraPoints
        return pointConfig
    }

}