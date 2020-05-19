package ua.nure.makieiev.ark.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class FilterWorkLogDto(@NotNull
                            var filterUnitId: Long? = null,
                            @NotNull
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
                            var scanDateTime: LocalDateTime? = null,
                            @NotNull
                            var temperature: String? = null,
                            @NotNull
                            var filterContamination: BigDecimal? = null)