package ua.nure.makieiev.ark.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Table(name = "units")
data class Unit(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id_unit")
        var id: Long? = null,
        @Size(min = 6, max = 100)
        @Column(name = "Title")
        var title: String? = null,
        @Size(min = 0, max = 250)
        @Column(name = "Description")
        var description: String? = null,
        @Size(min = 6, max = 50)
        @Column(name = "Status")
        var status: String? = null,
        @OneToMany(mappedBy = "unit", fetch = FetchType.LAZY)
        var workPlaces: List<WorkPlace> = emptyList()
) {
    override fun toString(): String {
        return "Unit(id=$id," +
                " title=$title," +
                " description=$description," +
                " status=$status," +
                " workPlaces=$workPlaces)"
    }
}