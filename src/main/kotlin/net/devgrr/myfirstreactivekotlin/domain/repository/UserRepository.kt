package net.devgrr.myfirstreactivekotlin.domain.repository

import net.devgrr.myfirstreactivekotlin.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository: CoroutineCrudRepository<User, Long> {
}