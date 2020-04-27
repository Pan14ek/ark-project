package ua.nure.makieiev.ark.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import ua.nure.makieiev.ark.exception.NotUniqueRoleFieldException
import ua.nure.makieiev.ark.model.entity.Role
import ua.nure.makieiev.ark.repository.RoleRepository
import ua.nure.makieiev.ark.service.RoleService

@Service
class RoleServiceImpl @Autowired constructor(private val roleRepository: RoleRepository) : RoleService {

    override fun findByTitle(title: String): Role {
        return roleRepository.findByTitle(title)
    }

    override fun findBySymbol(symbol: String): Role {
        return roleRepository.findBySymbol(symbol)
    }

    override fun save(role: Role): Role {
        try {
            return roleRepository.save(role)
        } catch (exception: DataIntegrityViolationException) {
            throw NotUniqueRoleFieldException("The database contains a role field with this information",
                    exception, enableSuppression = true, writableStackTrace = true)
        }
    }

}