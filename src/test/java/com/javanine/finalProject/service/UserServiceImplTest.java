package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.repository.UserRepository;
import com.javanine.finalProject.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        UserDTO user = new UserDTO();
        user.setEmail("danielBrown@gmail.com");

        Mockito.when(userRepository.findInEmail(user.getEmail()))
                .thenReturn(user);
    }

    @Test
    public void whenValidUserEmail_thenUserShouldBeFound() {
        UserDTO found = userService.findByEmail("danielBrown@gmail.com");

        assertThat(found.getEmail())
                .isEqualTo("danielBrown@gmail.com");
    }
}
