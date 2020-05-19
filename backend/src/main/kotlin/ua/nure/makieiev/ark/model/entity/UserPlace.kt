package ua.nure.makieiev.ark.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "user_places", schema = "public")
data class UserPlace(@NotNull
                     @Id
                     @GeneratedValue(strategy = GenerationType.IDENTITY)
                     @Column(name = "Id_user_place")
                     var id: Long? = null,
                     @ManyToOne(fetch = LAZY)
                     @JoinColumn(name = "Id_work_place")
                     var workPlace: WorkPlace? = null,
                     @ManyToOne(fetch = LAZY)
                     @JoinColumn(name = "Id_user")
                     var user: User? = null) {
    override fun toString(): String {
        return "UserPlace(id=$id, workPlace=$workPlace, user=$user)"
    }
}