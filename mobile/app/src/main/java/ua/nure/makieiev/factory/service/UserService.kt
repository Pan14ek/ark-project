package ua.nure.makieiev.factory.service

import android.content.Context
import ua.nure.makieiev.factory.model.dto.SignInUserDto
import ua.nure.makieiev.factory.model.dto.SignUpUserDto
import ua.nure.makieiev.factory.model.entity.User

interface UserService {

    fun signUp(signUpUserDto: SignUpUserDto, context: Context): Boolean

    fun signIn(signInUserDto: SignInUserDto, context: Context)

    fun getUserByLogin(login: String, context: Context): User?

}