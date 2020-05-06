package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "users_personal_schedules", schema = "public")
data class UserPersonalSchedule(@Id
                                @GeneratedValue(strategy = IDENTITY)
                                @Column(name = "Id_user_personal_schedule")
                                val id: Long? = null,
                                @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                                @Column(name = "Work_date")
                                var workDate: LocalDate? = null,
                                @Column(name = "Confirm")
                                var confirm: Boolean? = null,
                                @ManyToOne(fetch = FetchType.LAZY)
                                @JoinColumn(name = "Id_user")
                                var user: User? = null,
                                @ManyToOne(fetch = FetchType.LAZY)
                                @JoinColumn(name = "Id_personal_schedule")
                                var personalSchedule: PersonalSchedule? = null
) {
    override fun toString(): String {
        return "UserPersonalSchedule(id=$id, " +
                "workDate=$workDate," +
                " confirm=$confirm," +
                " user=$user," +
                " personalSchedule=$personalSchedule)"
    }
}