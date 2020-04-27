package ua.nure.makieiev.ark.model.entity

data class AuthToken(val token: String,
                     val user: User) {
    override fun toString(): String {
        return "AuthToken(token='$token', user=$user)"
    }
}