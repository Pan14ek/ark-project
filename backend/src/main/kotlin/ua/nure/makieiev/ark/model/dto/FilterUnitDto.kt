package ua.nure.makieiev.ark.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.validation.constraints.NotNull

data class FilterUnitDto(@NotNull
                         var filterId: Long? = null,
                         @NotNull
                         var unitId: Long? = null,
                         @NotNull
                         @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                         var dateInstall: LocalDate? = null,
                         @NotNull
                         var status: String? = null,
                         @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                         var dateRemoval: LocalDate? = null)