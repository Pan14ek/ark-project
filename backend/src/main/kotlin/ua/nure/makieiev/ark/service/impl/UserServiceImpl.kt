package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.exception.NotUniqueUserFieldException
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.repository.UserRepository
import ua.nure.makieiev.ark.service.UserService
import java.util.*

@Service(value = "userService")
class UserServiceImpl @Autowired constructor(private val userRepository: UserRepository,
                                             private val bcryptEncoder: BCryptPasswordEncoder) : UserService, UserDetailsService {

    override fun findById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    override fun findByLogin(login: String): User {
        return userRepository.findByLogin(login)
    }

    override fun save(user: User): User {
        try {
            user.password = user.password?.let { bcryptEncoder.encode(it) }
            return userRepository.save(user)
        } catch (exception: DataIntegrityViolationException) {
            throw NotUniqueUserFieldException("The database contains a user field with this information",
                    exception, enableSuppression = true, writableStackTrace = true)
        }
    }

    override fun update(user: User): Boolean {
        userRepository.save(user)
        return true
    }

    override fun checkPassword(user: User, password: String): Boolean {
        return bcryptEncoder.matches(password, user.password)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = userRepository.findByLogin(username!!)
        return org.springframework.security.core.userdetails.User(user.login, user.password, getAuthority(user))
    }

    private fun getAuthority(user: User): Set<SimpleGrantedAuthority>? {
        val authorities: MutableSet<SimpleGrantedAuthority> = HashSet()
        authorities.add(SimpleGrantedAuthority("ROLE_" + user.role?.title))
        return authorities
    }

}