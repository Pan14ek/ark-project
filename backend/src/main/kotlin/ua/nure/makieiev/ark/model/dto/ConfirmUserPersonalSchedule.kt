package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class ConfirmUserPersonalSchedule(val id: Long,
                                       @NotNull
                                       val userPersonalScheduleId: Long? = null,
                                       @NotNull
                                       val confirm: Boolean? = null)