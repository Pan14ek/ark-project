package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UnitDto(
        @NotNull
        @Size(min = 5, max = 100)
        val title: String? = null,
        @Size(min = 0, max = 250)
        var description: String? = null,
        @NotNull
        @Size(min = 3, max = 50)
        var status: String? = null
)