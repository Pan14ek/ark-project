package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.UserPlace
import java.util.*

interface UserPlaceService {

    fun save(userPlace: UserPlace): UserPlace

    fun findById(id: Long): Optional<UserPlace>

    fun findByUserId(userId: Long): UserPlace

    fun findAll(): List<UserPlace>

}