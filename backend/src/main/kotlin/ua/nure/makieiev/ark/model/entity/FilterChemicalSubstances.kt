package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "filters_chemical_substances", schema = "public")
data class FilterChemicalSubstances(@Id
                                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                                    @Column(name = "id_filter_chemical_substance")
                                    val id: Long? = null,
                                    @ManyToOne
                                    @JoinColumn(name = "id_filter")
                                    @JsonManagedReference
                                    var filter: Filter? = null,
                                    @ManyToOne
                                    @JoinColumn(name = "id_chemical_substance")
                                    @JsonManagedReference
                                    var chemicalSubstance: ChemicalSubstance? = null)