package abika.sinau.hospital.user.controller

import abika.sinau.hospital.BaseResponse
import abika.sinau.hospital.user.MessageResponse
import abika.sinau.hospital.user.entity.User
import abika.sinau.hospital.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/{name}")
    fun getUserByName(@PathVariable(value = "name") userName: String): BaseResponse<User>? {
        return BaseResponse(
                status = true,
                message = MessageResponse.SUCCESS,
                data = userService.getUserByName(userName)
        )
    }

    @GetMapping
    fun getUsers(): BaseResponse<List<User>> {
        return BaseResponse(
                status = true,
                message = MessageResponse.SUCCESS,
                data = userService.getUsers()
        )
    }

    @PostMapping
    fun addUserRole(@RequestBody user: User): BaseResponse<List<User>> {
        return BaseResponse(
                status = true,
                message = MessageResponse.SUCCESS,
                data = userService.addUser(user)
        )
    }

    @GetMapping("/ids")
    fun getIds(): BaseResponse<List<String>> {
        return BaseResponse(status = true, message = MessageResponse.SUCCESS, data = userService.getIds())
    }

    @GetMapping("/role/{role-name}")
    fun getUserByRole(@PathVariable(value = "role-name") roleName: String): BaseResponse<User>? {
        return BaseResponse(
                status = true,
                message = MessageResponse.SUCCESS,
                data = userService.getUserByRole(roleName)
        )
    }
}