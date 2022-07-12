package abika.sinau.hospital.role.service

import abika.sinau.hospital.role.entity.Role
import abika.sinau.hospital.role.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl : RoleService {

    @Autowired
    private lateinit var roleRepository: RoleRepository

    override fun getRoles(): List<Role> {
        return roleRepository.getRoles()
    }

    override fun addRoles(role: Role): List<Role> {
        return roleRepository.addRoles(role.name)
    }
}