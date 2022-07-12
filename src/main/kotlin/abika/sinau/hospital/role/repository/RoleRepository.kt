package abika.sinau.hospital.role.repository

import abika.sinau.hospital.role.entity.Role

interface RoleRepository {
    fun getRoles(): List<Role>
    fun addRoles(roleName: String): List<Role>
}