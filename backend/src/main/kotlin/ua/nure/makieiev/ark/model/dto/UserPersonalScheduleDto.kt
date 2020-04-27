package ua.nure.makieiev.ark.model.dto

import java.time.LocalDate
import javax.validation.constraints.NotNull

data class UserPersonalScheduleDto(@NotNull
                                   val personalScheduleId: Long? = null,
                                   @NotNull
                                   val userLogin: String? = null,
                                   @NotNull
                                   val workDate: LocalDate? = null)