package ru.step.codeexample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import ru.step.codeexample.model.User
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, UUID>, JpaSpecificationExecutor<User>