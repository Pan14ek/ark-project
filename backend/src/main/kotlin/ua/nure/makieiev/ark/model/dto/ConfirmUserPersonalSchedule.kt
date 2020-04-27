package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class ConfirmUserPersonalSchedule(@NotNull
                                       val userPersonalScheduleId: Long? = null,
                                       @NotNull
                                       val confirm: Boolean? = null) {
}