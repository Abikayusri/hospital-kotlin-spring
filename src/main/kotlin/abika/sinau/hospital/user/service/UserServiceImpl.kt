package abika.sinau.hospital.user.service

import abika.sinau.hospital.user.entity.User
import abika.sinau.hospital.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getUserByName(name: String): User? {
        return userRepository.getUserByName(name)
    }

    override fun getUsers(): List<User> {
        return userRepository.getUsers()
    }

    override fun addUser(user: User): List<User> {
        return userRepository.addUser(user.name, user.role?.name.toString())
    }

    override fun getIds(): List<String> {
        return userRepository.getUsers().map { it.id }
    }

    override fun getUserByRole(roleName: String): User? {
        return userRepository.getUserByRole(roleName)
    }
}