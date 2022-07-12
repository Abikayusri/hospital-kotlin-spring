package abika.sinau.hospital.user.repository

import abika.sinau.hospital.role.entity.Role
import abika.sinau.hospital.user.entity.User
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    private val userList: MutableList<User> = mutableListOf()

    init {
        userList.addAll(listOf(
                User(name = "Purwo", role = Role(name = "Dokter")),
                User(name = "Purwoceng", role = Role(name = "CS")),
        ))
    }

    override fun getUserByName(name: String): User? {
        return userList.find { it.name == name }
    }

    override fun getUsers(): List<User> {
        return userList
    }

    override fun addUser(name: String, role: String): List<User> {
        userList.add(User(name = name, role = Role(name = role)))
        return userList
    }

    override fun getUserByRole(roleName: String): User? {
        val user = userList.find { it.role?.name == roleName }
        return user
    }
}