package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "work_logs", schema = "public")
data class WorkLog(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   @Column(name = "Id_work_log")
                   var id: Long? = null,
                   @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                   @Column(name = "Work_date")
                   var workDate: LocalDate? = null,
                   @Column(name = "Amount_points")
                   var amountPoints: Int? = null,
                   @ManyToOne(fetch = FetchType.LAZY)
                   @JoinColumn(name = "Id_user")
                   var user: User? = null
) {
    override fun toString(): String {
        return "WorkLog(id=$id, workDate=$workDate, amountPoints=$amountPoints, user=$user)"
    }
}