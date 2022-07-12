package abika.sinau.hospital.role.repository

import abika.sinau.hospital.role.entity.Role
import org.springframework.stereotype.Repository

@Repository
class RoleRepositoryImpl : RoleRepository {
    private val roleList: MutableList<Role> = mutableListOf()

    init {
        roleList.addAll(listOf(
          Role(name = "Dokter"),
          Role(name = "CS"),
          Role(name = "Engineer"),
        ))
    }

    override fun getRoles(): List<Role> {
        return roleList
    }

    override fun addRoles(roleName: String): List<Role> {
        roleList.add(Role(name = roleName))
        return roleList
    }
}