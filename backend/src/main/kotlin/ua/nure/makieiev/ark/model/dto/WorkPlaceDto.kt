package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class WorkPlaceDto(@NotNull
                        var title: String? = null,
                        @NotNull
                        var size: Int? = null,
                        @NotNull
                        var unitId: Long? = null)