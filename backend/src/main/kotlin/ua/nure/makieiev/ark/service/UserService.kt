package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.User
import java.util.*

interface UserService {

    fun findById(id: Long): Optional<User>

    fun findByLogin(login: String): User

    fun save(user: User): User

    fun update(user: User): Boolean

    fun checkPassword(user: User, password: String): Boolean

    fun findAll(): List<User>

}