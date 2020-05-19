package ua.nure.makieiev.ark.util.converter.impl

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.FilterDto
import ua.nure.makieiev.ark.model.entity.Filter
import ua.nure.makieiev.ark.util.converter.Converter

@Component
class FilterConverter : Converter<FilterDto, Filter> {

    override fun fill(any: FilterDto): Filter {
        val filter = Filter()
        filter.title = any.title
        filter.diameter = any.diameter
        filter.filterType = any.filterType
        return filter
    }

}