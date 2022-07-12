package abika.sinau.hospital.user.service

import abika.sinau.hospital.user.entity.User

interface UserService {
    fun getUserByName(name: String): User?
    fun getUsers(): List<User>
    fun addUser(user: User): List<User>
    fun getIds(): List<String>
//    fun getUserByRole(roleName: String): User?
}