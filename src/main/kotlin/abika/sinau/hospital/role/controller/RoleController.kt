package abika.sinau.hospital.role.controller

import abika.sinau.hospital.BaseResponse
import abika.sinau.hospital.role.entity.Role
import abika.sinau.hospital.role.service.RoleService
import abika.sinau.hospital.user.MessageResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/role")
class RoleController {
    @Autowired
    private lateinit var roleService: RoleService

    @GetMapping
    fun getUsers(): BaseResponse<List<Role>> {
        return BaseResponse(
                status = true,
                message = MessageResponse.SUCCESS,
                data = roleService.getRoles()
        )
    }

    @PostMapping
    fun addUser(@RequestBody role: Role): BaseResponse<List<Role>> {
        return BaseResponse(
                status = true,
                message = MessageResponse.SUCCESS,
                data = roleService.addRoles(role)
        )
    }
}