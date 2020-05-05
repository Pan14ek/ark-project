package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class PointConfigDto(
        val id: Long,
        @NotNull
        val defaultPoints: Int? = null,
        @NotNull
        val extraPoints: Int? = null)