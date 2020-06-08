package ua.nure.makieiev.ark.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.nure.makieiev.ark.model.entity.FilterChemicalSubstances

@Repository
interface FilterChemicalSubstancesRepository : CrudRepository<FilterChemicalSubstances, Long> {

    fun findAllChemicalSubstancesByFilterId(filterId: Long): List<FilterChemicalSubstances>

}