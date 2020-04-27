package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Table(name = "roles")
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id_role")
        var id: Long? = null,
        @Size(min = 6, max = 45)
        @Column(name = "Title")
        var title: String? = null,
        @Size(min = 1, max = 45)
        @Column(name = "Symbol")
        var symbol: String? = null,
        @Size(min = 0, max = 200)
        @Column(name = "Description")
        var description: String? = null,
        @JsonIgnore
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "Id_role")
        var user: User? = null
)