package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.PointConfig
import java.util.*

interface PointConfigService {

    fun findById(id: Long): Optional<PointConfig>

    fun save(pointConfig: PointConfig): PointConfig

}