package ua.nure.makieiev.ark.model.entity

import java.math.BigDecimal
import java.util.*

data class FilterWorkLogStatistic(var avgTemperature: String? = null,
                                  var sumFilterContamination: BigDecimal? = null,
                                  var scanDate: Date? = null)