package com.boots.service;

import com.boots.entity.User;
import com.boots.repository.RoleRepository;
import com.boots.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    RoleRepository roleRepository;
    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void saveUserTest() {
        User user = new User();
        boolean isUserCreated = userService.saveUser(user);
        assertTrue(isUserCreated);
        assertNotNull(user.getRoles());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void whenFailUserTest() {
        User user = new User();
        user.setUsername("Sekator");
        Mockito.doReturn(new User())
                .when(userRepository)
                .findByUsername("Sekator");
        boolean isUserCreated = userService.saveUser(user);
        assertFalse(isUserCreated);
        assertNull(user.getRoles());
        Mockito.verify(userRepository, Mockito.times(0)).save(user);
    }

    @Test
    public void findUserById() {
        assertNotNull(userService.findUserById(1L));
        assertNull(userService.findUserById(100L).getRoles());
    }
}