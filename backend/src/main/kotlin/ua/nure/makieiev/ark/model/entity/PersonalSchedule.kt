package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "personal_schedules", schema = "public")
data class PersonalSchedule(
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "Id_personal_schedule")
        val id: Long? = null,
        @NotNull
        @Column(name = "Amount_days")
        var amountDays: Int? = null,
        @JsonIgnore
        @OneToMany(mappedBy = "personalSchedule", fetch = FetchType.LAZY)
        var userPersonalSchedules: List<UserPersonalSchedule> = emptyList()
) {
    override fun toString(): String {
        return "PersonalSchedule(id=$id, " +
                "amountDays=$amountDays, " +
                "userPersonalSchedules=$userPersonalSchedules)"
    }
}