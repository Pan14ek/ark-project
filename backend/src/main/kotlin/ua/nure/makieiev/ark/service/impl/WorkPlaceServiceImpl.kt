package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.WorkPlace
import ua.nure.makieiev.ark.repository.WorkPlaceRepository
import ua.nure.makieiev.ark.service.WorkPlaceService
import java.util.*

@Service
class WorkPlaceServiceImpl @Autowired constructor(private val workPlaceRepository: WorkPlaceRepository) : WorkPlaceService {

    override fun save(workPlace: WorkPlace): WorkPlace {
        return workPlaceRepository.save(workPlace)
    }

    override fun findById(id: Long): Optional<WorkPlace> {
        return workPlaceRepository.findById(id)
    }

    override fun findAll(): List<WorkPlace> {
        return workPlaceRepository.findAll() as MutableList
    }

}