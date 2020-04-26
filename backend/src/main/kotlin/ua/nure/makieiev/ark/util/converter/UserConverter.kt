package ua.nure.makieiev.ark.util.converter

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.UserDto
import ua.nure.makieiev.ark.model.entity.User

@Component
class UserConverter {

    fun fillUser(userDto: UserDto): User {
        val user = User()
        user.firstName = userDto.firstName
        user.lastName = userDto.lastName
        user.login = userDto.login
        user.email = userDto.email
        user.password = userDto.password
        return user
    }

}