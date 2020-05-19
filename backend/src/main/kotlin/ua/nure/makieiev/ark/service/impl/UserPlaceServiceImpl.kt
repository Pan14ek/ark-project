package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.UserPlace
import ua.nure.makieiev.ark.repository.UserPlaceRepository
import ua.nure.makieiev.ark.service.UserPlaceService
import java.util.*

@Service
class UserPlaceServiceImpl @Autowired constructor(private val userPlaceRepository: UserPlaceRepository) : UserPlaceService {

    override fun save(userPlace: UserPlace): UserPlace {
        return userPlaceRepository.save(userPlace)
    }

    override fun findById(id: Long): Optional<UserPlace> {
        return userPlaceRepository.findById(id)
    }

    override fun findByUserId(userId: Long): UserPlace {
        return userPlaceRepository.findByUserId(userId)
    }

    override fun findAll(): List<UserPlace> {
        return userPlaceRepository.findAll() as MutableList
    }

}