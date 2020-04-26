package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.PointConfig

interface PointConfigService {

    fun findById(id: Long): PointConfig
    fun save(pointConfig: PointConfig): PointConfig

}