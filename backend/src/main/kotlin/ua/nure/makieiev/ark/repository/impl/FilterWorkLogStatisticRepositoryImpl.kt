package ua.nure.makieiev.ark.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.FilterWorkLogStatistic
import ua.nure.makieiev.ark.repository.FilterWorkLogStatisticRepository
import java.math.BigDecimal
import java.util.*
import javax.sql.DataSource

@Repository
class FilterWorkLogStatisticRepositoryImpl @Autowired constructor(private val dataSource: DataSource) : FilterWorkLogStatisticRepository {

    override fun getStatisticByFilerWorkLog(): List<FilterWorkLogStatistic> {
        val jdbcTemplate = JdbcTemplate(dataSource)
        val filterWorkLogStatisticList = mutableListOf<FilterWorkLogStatistic>()
        val rows = jdbcTemplate.queryForList("SELECT CAST(round(AVG(CAST(fwl.temperature AS NUMERIC))) AS VARCHAR) as temperature, SUM(fwl.filter_contamination) as filter_contamination, fwl.scan_date_time FROM filter_work_log fwl group by fwl.scan_date_time order by fwl.scan_date_time")
        rows.forEach {
            run {
                val filterWorkLogStatistic = FilterWorkLogStatistic()
                filterWorkLogStatistic.avgTemperature = it["temperature"] as String?
                filterWorkLogStatistic.sumFilterContamination = it["filter_contamination"] as BigDecimal?
                filterWorkLogStatistic.scanDate = it["scan_date_time"] as Date?
                filterWorkLogStatisticList.add(filterWorkLogStatistic)
            }
        }
        return filterWorkLogStatisticList
    }

}