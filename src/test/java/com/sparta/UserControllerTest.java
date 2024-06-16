package com.sparta;

import com.sparta.lck_news.controller.UserController;
import com.sparta.lck_news.entity.User;
import com.sparta.lck_news.entity.UserStatus;
import com.sparta.lck_news.repository.UserRepository;
import com.sparta.lck_news.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test

    void getUserById() throws Exception {
        // given
        User user = new User();
        user.setId(1L);
        user.setName("testname");
        user.setPassword("test1234123");
        user.setStatus(UserStatus.ACTIVE);
        user.setEmail("test@test.com");

        given(userRepository.findByUsername(user.getUsername())).willReturn(Optional.of(user));

        // when & then
        mockMvc.perform(get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("username"));
    }
}
