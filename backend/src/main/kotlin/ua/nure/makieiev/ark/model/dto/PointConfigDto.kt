package ua.nure.makieiev.ark.model.dto

import javax.validation.constraints.NotNull

class PointConfigDto(
        @NotNull
        var defaultPoints: Int? = null,
        @NotNull
        var extraPoints: Int? = null)