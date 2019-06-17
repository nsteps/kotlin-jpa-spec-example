package ru.step.codeexample.service.impl

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.step.codeexample.model.dto.UserRequestDto
import ru.step.codeexample.repository.UserRepository
import ru.step.codeexample.service.UserService
import ru.step.codeexample.specification.UserSpecification

@Service
class UserServiceImpl(
        val userRepository: UserRepository,
        val userSpecification: UserSpecification
) : UserService {
    override fun findUsers(request: UserRequestDto, pageable: Pageable) =
            userRepository.findAll(userSpecification.getFilter(request), pageable)
}