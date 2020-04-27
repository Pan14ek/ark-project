package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.PointConfig
import ua.nure.makieiev.ark.repository.PointConfigRepository
import ua.nure.makieiev.ark.service.PointConfigService
import java.util.*

@Service
class PointConfigServiceImpl @Autowired constructor(private val pointConfigRepository: PointConfigRepository) : PointConfigService {

    override fun findById(id: Long): Optional<PointConfig> {
        return pointConfigRepository.findById(id)
    }

    override fun save(pointConfig: PointConfig): PointConfig {
        return pointConfigRepository.save(pointConfig)
    }

}