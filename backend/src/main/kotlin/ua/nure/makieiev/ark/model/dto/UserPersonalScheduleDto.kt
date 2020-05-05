package ua.nure.makieiev.ark.model.dto

import java.time.LocalDate
import javax.validation.constraints.NotNull

data class UserPersonalScheduleDto(val id: Long,
                                   @NotNull
                                   val personalScheduleId: Long? = null,
                                   @NotNull
                                   val userLogin: String? = null,
                                   @NotNull
                                   val workDate: LocalDate? = null)