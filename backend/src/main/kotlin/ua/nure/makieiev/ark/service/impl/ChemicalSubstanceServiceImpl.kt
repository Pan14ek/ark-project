package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.model.entity.ChemicalSubstance
import ua.nure.makieiev.ark.repository.ChemicalSubstanceRepository
import ua.nure.makieiev.ark.service.ChemicalSubstanceService
import java.util.*

@Service
class ChemicalSubstanceServiceImpl @Autowired constructor(private val chemicalSubstanceRepository: ChemicalSubstanceRepository) : ChemicalSubstanceService {

    override fun save(chemicalSubstance: ChemicalSubstance): ChemicalSubstance {
        return chemicalSubstanceRepository.save(chemicalSubstance)
    }

    override fun findById(id: Long): Optional<ChemicalSubstance> {
        return chemicalSubstanceRepository.findById(id)
    }

    override fun update(chemicalSubstance: ChemicalSubstance): ChemicalSubstance {
        return chemicalSubstanceRepository.save(chemicalSubstance)
    }

    override fun findAll(): List<ChemicalSubstance> {
        return chemicalSubstanceRepository.findAll() as MutableList
    }

}