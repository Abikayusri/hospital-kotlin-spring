package abika.sinau.hospital.user.repository

import abika.sinau.hospital.user.entity.User

interface UserRepository {
    fun getUserByName(name: String): User?
    fun getUsers(): List<User>
    fun addUser(name: String, role: String): List<User>
//    fun getUserByRole(roleName: String): User?
}