package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "filter_work_log", schema = "public")
data class FilterWorkLog(@Id
                         @GeneratedValue(strategy = GenerationType.IDENTITY)
                         @Column(name = "Id_filter_work_log")
                         var id: Long? = null,
                         @JsonManagedReference
                         @ManyToOne
                         @JoinColumn(name = "Id_filter_unit")
                         var filterUnit: FilterUnit? = null,
                         @Column(name = "Scan_date_time")
                         var scanDateTime: LocalDateTime? = null,
                         @Column(name = "Temperature")
                         var temperature: String? = null,
                         @Column(name = "Filter_contamination")
                         var filterContamination: BigDecimal? = null)