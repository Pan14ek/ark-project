package ua.nure.makieiev.ark.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
data class User(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Column(name = "Id_user")
                var id: Long? = null,
                @Size(min = 6, max = 45)
                @Column(name = "First_name")
                var firstName: String? = null,
                @Size(min = 6, max = 45)
                @Column(name = "Last_name")
                var lastName: String? = null,
                @Size(min = 6, max = 45)
                @Column(name = "Login")
                var login: String? = null,
                @Email
                @Column(name = "Email")
                var email: String? = null,
                @Size(min = 6, max = 45)
                @Column(name = "Password")
                var password: String? = null,
                @OneToOne(fetch = FetchType.LAZY)
                @JoinColumn(name = "Id_role")
                var role: Role? = null,
                @JsonIgnore
                @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
                var workLogs: List<WorkLog> = emptyList()
)