package ru.step.codeexample.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(
        @Id
        val id: UUID = UUID.randomUUID(),

        val firstName: String,

        val secondName: String
)