package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

data class UserPlaceDto(@NotNull
                        var workPlaceId: Long,
                        @NotNull
                        var userId: Long)