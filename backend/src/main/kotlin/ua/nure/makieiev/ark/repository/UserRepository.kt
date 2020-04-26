package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.User

@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByLogin(login: String): User

}