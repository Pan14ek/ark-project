package ua.nure.makieiev.factory.model.dto

data class SignUpUserDto(
    var firstName: String? = null,
    var lastName: String? = null,
    var login: String? = null,
    var email: String? = null,
    var password: String? = null,
    var repeatPassword: String? = null
)