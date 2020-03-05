package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.User

interface UserService {

    fun save(user: User): User
    fun update(user:User):Boolean

}