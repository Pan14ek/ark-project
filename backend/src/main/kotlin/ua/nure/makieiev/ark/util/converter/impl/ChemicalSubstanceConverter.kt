package ua.nure.makieiev.ark.util.converter.impl

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.ChemicalSubstanceDto
import ua.nure.makieiev.ark.model.entity.ChemicalSubstance
import ua.nure.makieiev.ark.util.converter.Converter

@Component
class ChemicalSubstanceConverter : Converter<ChemicalSubstanceDto, ChemicalSubstance> {

    override fun fill(any: ChemicalSubstanceDto): ChemicalSubstance {
        val chemicalSubstance = ChemicalSubstance()
        chemicalSubstance.title = any.title
        chemicalSubstance.formula = any.formula
        return chemicalSubstance
    }

}