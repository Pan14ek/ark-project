package ua.nure.makieiev.factory.model.entity

data class User(
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var login: String? = null,
    var email: String? = null,
    var password: String? = null,
    var role: Role? = null
)