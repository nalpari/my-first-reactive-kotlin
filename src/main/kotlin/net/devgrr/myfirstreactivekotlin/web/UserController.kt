package net.devgrr.myfirstreactivekotlin.web

import net.devgrr.myfirstreactivekotlin.model.UserRequest
import net.devgrr.myfirstreactivekotlin.model.UserResponse
import net.devgrr.myfirstreactivekotlin.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
) {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody request: UserRequest): UserResponse = userService.create(request)

    @GetMapping("")
    fun findAll() = userService.findAll()

    @GetMapping("/{id}")
    suspend fun find(@PathVariable id: Long): UserResponse = userService.find(id)

    @PutMapping("/{id}")
    suspend fun modify(@PathVariable id: Long, @RequestBody request: UserRequest): UserResponse = userService.modify(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = userService.delete(id)
}