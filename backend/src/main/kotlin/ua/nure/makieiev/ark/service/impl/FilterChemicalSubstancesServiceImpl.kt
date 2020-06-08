package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.FilterChemicalSubstances
import ua.nure.makieiev.ark.repository.FilterChemicalSubstancesRepository
import ua.nure.makieiev.ark.service.FilterChemicalSubstancesService
import java.util.*

@Service
class FilterChemicalSubstancesServiceImpl @Autowired constructor(val filterChemicalSubstancesRepository: FilterChemicalSubstancesRepository) : FilterChemicalSubstancesService {

    override fun save(filterChemicalSubstances: FilterChemicalSubstances): FilterChemicalSubstances {
        return filterChemicalSubstancesRepository.save(filterChemicalSubstances)
    }

    override fun findById(filterChemicalSubstancesId: Long): Optional<FilterChemicalSubstances> {
        return filterChemicalSubstancesRepository.findById(filterChemicalSubstancesId)
    }

    override fun findAllByFilterId(filterId: Long): List<FilterChemicalSubstances> {
        return filterChemicalSubstancesRepository.findAllChemicalSubstancesByFilterId(filterId)
    }

}