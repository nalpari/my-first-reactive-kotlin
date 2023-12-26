package net.devgrr.myfirstreactivekotlin.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.devgrr.myfirstreactivekotlin.domain.entity.User
import net.devgrr.myfirstreactivekotlin.domain.repository.UserRepository
import net.devgrr.myfirstreactivekotlin.model.UserRequest
import net.devgrr.myfirstreactivekotlin.model.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService (
    private val userRepository: UserRepository,
){
    @Transactional
    suspend fun create(userRequest: UserRequest): UserResponse {
        val user = User(
            username = userRequest.username,
            email = userRequest.email,
            password = userRequest.password,
        )
        return UserResponse(userRepository.save(user))
    }

    fun findAll(): Flow<UserResponse> {
        return userRepository.findAll()
            .map { UserResponse(it) }
    }

    suspend fun find(id: Long): UserResponse {
        val user = userRepository.findById(id) ?: throw Exception("User not found")
        return UserResponse(user)
    }

    @Transactional
    suspend fun modify(id: Long, userRequest: UserRequest): UserResponse {
        val user = userRepository.findById(id) ?: throw Exception("User not found")
        return with(user) {
            this.username = userRequest.username
            this.email = userRequest.email
//            password = userRequest.password

            UserResponse(userRepository.save(this))
        }
    }

    @Transactional
    suspend fun delete(id: Long) {
        userRepository.deleteById(id)
    }
}