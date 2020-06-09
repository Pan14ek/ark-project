package ua.nure.makieiev.ark.repository

import ua.nure.makieiev.ark.model.entity.FilterWorkLogStatistic

interface FilterWorkLogStatisticRepository {

    fun getStatisticByFilerWorkLog(): List<FilterWorkLogStatistic>

}