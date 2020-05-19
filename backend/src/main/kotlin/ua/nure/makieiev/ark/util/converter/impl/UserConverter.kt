package ua.nure.makieiev.ark.util.converter.impl

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.UserDto
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.util.converter.Converter

@Component
class UserConverter : Converter<UserDto, User> {

    override fun fill(any: UserDto): User {
        val user = User()
        user.firstName = any.firstName
        user.lastName = any.lastName
        user.login = any.login
        user.email = any.email
        user.password = any.password
        return user
    }

}