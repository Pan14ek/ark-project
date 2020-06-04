package ua.nure.makieiev.factory.model.entity

import java.math.BigDecimal

data class FilterWorkLog(
    var id: Long? = null,
    var filterUnit: FilterUnit? = null,
    var scanDateTime: String? = null,
    var temperature: String? = null,
    var filterContamination: BigDecimal? = null
)