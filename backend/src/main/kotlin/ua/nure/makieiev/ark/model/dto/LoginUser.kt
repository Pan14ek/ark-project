package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LoginUser(@NotNull
                     @Size(min = 6, max = 45)
                     val login: String,
                     @NotNull
                     @Size(min = 6, max = 45)
                     val password: String)