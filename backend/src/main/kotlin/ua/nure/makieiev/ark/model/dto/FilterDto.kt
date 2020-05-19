package ua.nure.makieiev.ark.model.dto

import java.math.BigDecimal
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class FilterDto(@NotNull
                     @Size(min = 5, max = 45)
                     var title: String? = null,
                     @NotNull
                     var diameter: BigDecimal? = null,
                     @NotNull
                     @Size(min = 5, max = 45)
                     var filterType: String? = null)