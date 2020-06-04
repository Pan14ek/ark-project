package ua.nure.makieiev.factory.model.entity

import java.time.LocalDate

data class FilterUnit(
    var id: Long? = null,
    var filter: Filter? = null,
    var unit: Unit? = null,
    var dateInstall: String? = null,
    var status: String? = null,
    var dateRemoval: LocalDate? = null
)