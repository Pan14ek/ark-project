package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.Filter
import ua.nure.makieiev.ark.repository.FilterRepository
import ua.nure.makieiev.ark.service.FilterService
import java.util.*

@Service
class FilterServiceImpl @Autowired constructor(private val filterRepository: FilterRepository) : FilterService {

    override fun save(filter: Filter): Filter {
        return filterRepository.save(filter)
    }

    override fun updateFilter(filter: Filter): Boolean {
        filterRepository.save(filter)
        return true
    }

    override fun findById(id: Long): Optional<Filter> {
        return filterRepository.findById(id)
    }

    override fun findByTitle(title: String): Filter {
        return filterRepository.findByTitle(title)
    }

    override fun findAll(): List<Filter> {
        return filterRepository.findAll() as MutableList
    }

}