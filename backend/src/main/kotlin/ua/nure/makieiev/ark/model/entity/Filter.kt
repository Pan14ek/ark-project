package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "filters", schema = "public")
data class Filter(@Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  @Column(name = "Id_filter")
                  var id: Long? = null,
                  @Column(name = "title")
                  var title: String? = null,
                  @Column(name = "diameter")
                  var diameter: BigDecimal? = null,
                  @Column(name = "filter_type")
                  var filterType: String? = null,
                  @OneToMany(mappedBy = "filter")
                  @JsonBackReference
                  var filterUnit: List<FilterUnit>? = null,
                  @OneToMany(mappedBy = "filter")
                  @JsonBackReference
                  val filterChemicalSubstances: Set<FilterChemicalSubstances>? = null
)