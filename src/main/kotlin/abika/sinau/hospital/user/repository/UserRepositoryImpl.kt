package abika.sinau.hospital.user.repository

import abika.sinau.hospital.database.DatabaseComponent
import abika.sinau.hospital.role.entity.Role
import abika.sinau.hospital.role.repository.RoleRepository
import abika.sinau.hospital.user.entity.User
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<User> = databaseComponent.database.getDatabase("user").getCollection()
    private fun roleCollection(): MongoCollection<Role> = databaseComponent.database.getDatabase("role").getCollection()

    override fun getUserByName(name: String): User? {
        return userCollection().findOne(User::name eq name)
    }

    override fun getUsers(): List<User> {
        return userCollection().find().toList()
    }

    override fun addUser(name: String, role: String): List<User> {
        val checkRole = roleCollection().findOne(Role::name eq role)
        val newUserRole = User(name = name, role = Role(name = role))
        val newRole = Role(name = role)
        val insertUser = userCollection().insertOne(newUserRole)
        val insertRole = roleCollection().insertOne(newRole)

        return if (checkRole == null) {
            if (insertUser.wasAcknowledged() && insertRole.wasAcknowledged()) {
                getUsers()
            } else {
                throw IllegalStateException("Insert User Role Gagal ")
            }
        } else {
            if (insertRole.wasAcknowledged()) {
                getUsers()
            } else {
                throw IllegalStateException("Insert User Gagal")
            }
        }
    }
}