package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class PersonalScheduleDto(
        @NotNull
        val amountDays: Int? = null)