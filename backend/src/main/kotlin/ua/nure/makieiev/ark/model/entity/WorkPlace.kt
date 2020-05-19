package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "work_places", schema = "public")
data class WorkPlace(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id_work_place")
        var id: Long? = null,
        @Column(name = "Title")
        var title: String? = null,
        @Column(name = "Size")
        var size: Int? = null,
        @ManyToOne(fetch = LAZY)
        @JoinColumn(name = "Id_unit")
        @JsonManagedReference
        var unit: Unit? = null
) {
    override fun toString(): String {
        return "WorkPlace(id=$id, title=$title, size=$size, unit=$unit)"
    }
}