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
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Filter_work_log", schema = "public")
data class FilterWorkLog(@NotNull
                         @Id
                         @GeneratedValue(strategy = GenerationType.IDENTITY)
                         @Column(name = "Id_filter_work_log")
                         var id: Long? = null,
                         @NotNull
                         @JsonManagedReference
                         @ManyToOne
                         @JoinColumn(name = "Id_filter_unit")
                         var filterUnit: FilterUnit? = null,
                         @NotNull
                         @Column(name = "Scan_date_time")
                         var scanDateTime: LocalDateTime? = null,
                         @NotNull
                         @Column(name = "Temperature")
                         var temperature: String? = null,
                         @NotNull
                         @Column(name = "Filter_contamination")
                         var filterContamination: BigDecimal? = null)