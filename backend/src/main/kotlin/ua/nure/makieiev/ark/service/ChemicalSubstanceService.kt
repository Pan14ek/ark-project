package ua.nure.makieiev.ark.service

import ua.nure.makieiev.ark.model.entity.ChemicalSubstance
import java.util.*

interface ChemicalSubstanceService {

    fun save(chemicalSubstance: ChemicalSubstance): ChemicalSubstance

    fun findById(id: Long): Optional<ChemicalSubstance>

    fun update(chemicalSubstance: ChemicalSubstance): ChemicalSubstance

    fun findAll(): List<ChemicalSubstance>

}