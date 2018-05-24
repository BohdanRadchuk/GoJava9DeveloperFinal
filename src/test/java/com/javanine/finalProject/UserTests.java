package com.javanine.finalProject;

import com.javanine.finalProject.model.Role;
import com.javanine.finalProject.model.User;
import com.javanine.finalProject.repository.RoleRepository;
import com.javanine.finalProject.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testSaveGetUser() {
        User user = createNewUser("save@email.com");

        userRepository.save(user);
        User obtained = userRepository.findById(user.getId()).get();

        Assert.assertNotNull(obtained);
        Assert.assertEquals(user, obtained);
    }

    @Test
    public void testFindByEmail() {
        User user = createNewUser("findByEmail@email.com");

        userRepository.save(user);
        User obtained = userRepository.findByEmail(user.getEmail());

        Assert.assertEquals(user, obtained);
    }

    @Test
    public void testDeleteUser() {
        List<User> users;
        users = userRepository.findAll();
        if (users.isEmpty()) {
            User newUser = createNewUser("delete@email.com");
            userRepository.save(newUser);
            users = userRepository.findAll();
        }

        User user = users.get(users.size() - 1);
        long idForDelete = user.getId();
        userRepository.delete(user);
        userRepository.flush();
        Optional<User> obtained = userRepository.findById(idForDelete);

        Assert.assertFalse(obtained.isPresent());
    }

    private User createNewUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setPassword("pass");

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(3L).get());
        user.setRoles(roles);
        return user;
    }
}
