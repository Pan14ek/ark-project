package ua.nure.makieiev.ark.service.impl

import org.apache.commons.codec.digest.DigestUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.exception.NotUniqueUserFieldException
import ua.nure.makieiev.ark.model.entity.User
import ua.nure.makieiev.ark.repository.UserRepository
import ua.nure.makieiev.ark.service.UserService

@Service
class UserServiceImpl @Autowired constructor(private var userRepository: UserRepository) : UserService {

    override fun save(user: User): User {
        try {
            user.password = user.password?.let { encryptPassword(it) }
            return userRepository.save(user)
        } catch (exception: DataIntegrityViolationException) {
            throw NotUniqueUserFieldException("The database contains a user field with this information",exception, enableSuppression = true, writableStackTrace = true)
        }
    }

    override fun update(user: User): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun encryptPassword(password: String): String {
        return DigestUtils.md5Hex(password)
    }

}