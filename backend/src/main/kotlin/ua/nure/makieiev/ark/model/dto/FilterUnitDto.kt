package ua.nure.makieiev.ark.model.dto

import java.time.LocalDate

data class FilterUnitDto(var filterId: Long? = null,
                         var unitId: Long? = null,
                         var dateInstall: LocalDate? = null,
                         var status: String? = null,
                         var dateRemoval: LocalDate? = null)