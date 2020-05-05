package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RoleDto(
        val id: Long,
        @NotNull
        @Size(min = 5, max = 45)
        val title: String? = null,
        @NotNull
        @Size(min = 1, max = 45)
        val symbol: String? = null,
        @Size(min = 0, max = 250)
        val description: String? = null)