package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.PointConfig
import ua.nure.makieiev.ark.repository.PointConfigRepository
import ua.nure.makieiev.ark.service.PointConfigService

@Service
class PointConfigServiceImpl @Autowired constructor(var pointConfigRepository: PointConfigRepository) : PointConfigService {

    override fun findById(id: Long): PointConfig {
        TODO("Not yet implemented")
    }

    override fun save(pointConfig: PointConfig): PointConfig {
        TODO("Not yet implemented")
    }

}