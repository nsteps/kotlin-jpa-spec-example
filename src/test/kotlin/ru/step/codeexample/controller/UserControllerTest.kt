package ru.step.codeexample.controller

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import ru.step.codeexample.model.dto.UserRequestDto
import ru.step.codeexample.service.UserService

@RunWith(SpringRunner::class)
@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var userService: UserService

    @Test
    fun `on getUsersByFilter when no users was found should return OK`(){
        every { userService.findUsers(ofType(UserRequestDto::class), ofType(Pageable::class)) } returns Page.empty()

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @TestConfiguration
    class MockConfig {
        @Bean fun userService() = mockk<UserService>()
    }
}