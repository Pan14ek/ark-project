package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class FilterChemicalSubstancesDto(val id: Long? = null,
                                       @NotNull
                                       val filterId: Long,
                                       @NotNull
                                       val chemicalSubstanceId: Long)