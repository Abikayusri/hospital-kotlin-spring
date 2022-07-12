package abika.sinau.hospital.role.repository

import abika.sinau.hospital.database.DatabaseComponent
import abika.sinau.hospital.role.entity.Role
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class RoleRepositoryImpl : RoleRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun roleCollection(): MongoCollection<Role> = databaseComponent.database.getDatabase("role").getCollection()

    override fun getRoles(): List<Role> {
        return roleCollection().find().toList()
    }

    override fun addRoles(roleName: String): List<Role> {
        val newRole = Role(name = roleName)
        val insertRole = roleCollection().insertOne(newRole)
        return if (insertRole.wasAcknowledged()) {
            getRoles()
        } else {
            throw IllegalStateException("Insert Gagal")
        }
    }
}