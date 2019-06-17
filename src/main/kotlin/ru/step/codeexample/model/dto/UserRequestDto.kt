package ru.step.codeexample.model.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel("DTO запроса на получение пользователей по фильтру")
data class UserRequestDto(
        @ApiModelProperty("Id пользователя")
        val id: UUID? = null,

        @ApiModelProperty("Имя пользователя")
        val firstName: String? = null,

        @ApiModelProperty("Фамилия пользователя")
        val secondName: String? = null
)