package ua.nure.makieiev.factory.model.entity

import java.math.BigDecimal

data class Filter(
    var id: Long? = null,
    var title: String? = null,
    var diameter: BigDecimal? = null,
    var filterType: String? = null
)