package ru.step.codeexample.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.step.codeexample.model.User
import ru.step.codeexample.model.dto.UserRequestDto

interface UserService {
    fun findUsers(request: UserRequestDto, pageable: Pageable): Page<User>
}