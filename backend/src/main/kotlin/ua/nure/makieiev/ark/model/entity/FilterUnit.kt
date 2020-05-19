package ua.nure.makieiev.ark.model.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "Filters_units", schema = "public")
data class FilterUnit(@Id
                      @GeneratedValue(strategy = GenerationType.IDENTITY)
                      @Column(name = "Id_filter_unit")
                      var id: Long? = null,
                      @ManyToOne
                      @JoinColumn(name = "id_filter")
                      var filter: Filter? = null,
                      @ManyToOne
                      @JoinColumn(name = "id_unit")
                      var unit: Unit? = null,
                      @Column(name = "Date_install")
                      var dateInstall: LocalDate? = null,
                      @Column(name = "Status")
                      var status: String? = null,
                      @Column(name = "Date_removal")
                      var dateRemoval: LocalDate? = null)