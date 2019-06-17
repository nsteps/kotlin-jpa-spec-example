package ru.step.codeexample.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.step.codeexample.model.User
import ru.step.codeexample.model.dto.UserRequestDto
import ru.step.codeexample.service.UserService

@Api(tags = ["Контроллер пользователей"])
@RequestMapping(path = ["/v1/user"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
@RestController
@CrossOrigin
@ApiResponses(
        ApiResponse(code = 200, message = "Операция успешно выполнена"),
        ApiResponse(code = 500, message = "Ошибка сервера")
)
class UserController(
    val userService: UserService
) {
    @GetMapping
    @ApiOperation("Получение пользователей по фильтру")
    fun getUsersByFilter(userRequestDto: UserRequestDto, pageable: Pageable): Page<User> {
        return userService.findUsers(userRequestDto, pageable)
    }
}