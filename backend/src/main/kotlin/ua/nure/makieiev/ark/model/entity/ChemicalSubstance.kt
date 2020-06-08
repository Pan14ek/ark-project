package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "Chemical_Substances", schema = "public")
data class ChemicalSubstance(@Id
                             @GeneratedValue(strategy = GenerationType.IDENTITY)
                             @Column(name = "Id_chemical_substance")
                             var id: Long? = null,
                             @Column(name = "title")
                             var title: String? = null,
                             @Column(name = "formula")
                             var formula: String? = null,
                             @OneToMany(mappedBy = "chemicalSubstance")
                             @JsonBackReference
                             val filterChemicalSubstances: Set<FilterChemicalSubstances>? = null
)