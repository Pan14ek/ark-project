package ua.nure.makieiev.ark.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class WorkLogDto(
        val id: Long,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val workDate: LocalDate? = null,
        @NotNull
        @Size(min = 6, max = 45)
        val userLogin: String? = null
)