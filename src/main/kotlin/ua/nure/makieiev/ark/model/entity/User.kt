package ua.nure.makieiev.ark.model.entity

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
class User(@Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
           @Column(name = "id_user")
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
           var password: String? = null)