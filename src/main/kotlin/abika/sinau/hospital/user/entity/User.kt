package abika.sinau.hospital.user.entity

import abika.sinau.hospital.role.entity.Role
import java.util.*

data class User(
        var id: String = UUID.randomUUID().toString(),
        var name: String,
        var role: Role? = null
)
