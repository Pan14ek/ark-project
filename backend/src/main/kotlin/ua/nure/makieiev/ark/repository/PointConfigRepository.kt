package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.PointConfig

@Repository
interface PointConfigRepository : CrudRepository<PointConfig, Long>