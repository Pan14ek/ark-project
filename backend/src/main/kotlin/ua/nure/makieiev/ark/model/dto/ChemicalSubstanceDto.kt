package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class ChemicalSubstanceDto(@NotNull
                                var title: String? = null,
                                @NotNull
                                var formula: String? = null)