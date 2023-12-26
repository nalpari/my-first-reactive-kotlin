package net.devgrr.myfirstreactivekotlin.model

import net.devgrr.myfirstreactivekotlin.domain.entity.User

data class UserRequest(
    val username: String,
    val email: String,
    val password: String,
)

data class UserResponse (
    val id: Long,
    val username: String,
    val email: String,
    val createdAt: String,
    val updatedAt: String,
) {
    companion object {
        operator fun invoke(user: User) = with(user) {
            UserResponse(
                id = id!!,
                username = username,
                email = email,
                createdAt = createdAt.toString(),
                updatedAt = updatedAt.toString(),
            )
        }
    }
}