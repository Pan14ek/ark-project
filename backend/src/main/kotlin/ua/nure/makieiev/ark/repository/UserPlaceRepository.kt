package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.UserPlace

@Repository
interface UserPlaceRepository : CrudRepository<UserPlace, Long> {

    fun findByUserId(userId: Long): UserPlace

}