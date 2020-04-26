package ua.nure.makieiev.ark.service.impl

import org.apache.commons.codec.digest.DigestUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.exception.NotUniqueUserFieldException
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.repository.UserRepository
import ua.nure.makieiev.ark.service.UserService
import java.util.*

@Service
class UserServiceImpl @Autowired constructor(var userRepository: UserRepository) : UserService {

    override fun findById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    override fun findByLogin(login: String): User {
        return userRepository.findByLogin(login)
    }

    override fun save(user: User): User {
        try {
            user.password = user.password?.let { encryptPassword(it) }
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
        return user.password.equals(password)

    }

    private fun encryptPassword(password: String): String {
        return DigestUtils.md5Hex(password)
    }

}