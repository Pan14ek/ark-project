package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.FilterChemicalSubstances
import java.util.*

interface FilterChemicalSubstancesService {

    fun save(filterChemicalSubstances: FilterChemicalSubstances): FilterChemicalSubstances

    fun findById(filterChemicalSubstancesId: Long): Optional<FilterChemicalSubstances>

    fun findAllByFilterId(filterId: Long): List<FilterChemicalSubstances>

}