package net.devgrr.myfirstreactivekotlin.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import net.devgrr.myfirstreactivekotlin.model.UserRequest
import net.devgrr.myfirstreactivekotlin.model.UserResponse
import net.devgrr.myfirstreactivekotlin.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "User API")
class UserController(
    private val userService: UserService,
) {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new user")
    suspend fun create(@RequestBody request: UserRequest): UserResponse = userService.create(request)

    @GetMapping("")
    @Operation(summary = "Get all users")
    fun findAll() = userService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by id")
    suspend fun find(@PathVariable id: Long): UserResponse = userService.find(id)

    @PutMapping("/{id}")
    @Operation(summary = "Modify a user by id")
    suspend fun modify(@PathVariable id: Long, @RequestBody request: UserRequest): UserResponse = userService.modify(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a user by id")
    suspend fun delete(@PathVariable id: Long) = userService.delete(id)
}