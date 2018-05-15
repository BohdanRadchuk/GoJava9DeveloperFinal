package com.javanine.finalProject;

import com.javanine.finalProject.model.User;
import com.javanine.finalProject.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserTests {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testSaveGetUser() {
        User user = new User();
        user.setEmail("test_user");

        user.setPassword("pass");

        userServiceImpl.save(user);

        User obtained = userServiceImpl.findByEmail("test_user");

        Assert.assertNotNull(obtained);
        Assert.assertEquals(user.getEmail(), obtained.getEmail());
    }
}
