package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class UserDto(
        @NotNull
        @Size(min = 6, max = 45)
        var firstName: String,
        @NotNull
        @Size(min = 6, max = 45)
        var lastName: String,
        @NotNull
        @Size(min = 6, max = 45)
        var login: String,
        @NotNull
        @Email
        var email: String,
        @NotNull
        @Size(min = 6, max = 45)
        var password: String,
        @NotNull
        @Size(min = 6, max = 45)
        var repeatPassword: String)