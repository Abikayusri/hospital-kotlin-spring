package abika.sinau.hospital.role.service

import abika.sinau.hospital.role.entity.Role

interface RoleService {
    fun getRoles(): List<Role>
    fun addRoles(role: Role): List<Role>
}