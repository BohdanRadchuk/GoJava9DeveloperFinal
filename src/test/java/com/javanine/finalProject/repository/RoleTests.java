package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.Role;
import com.javanine.finalProject.model.enums.UserRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class RoleTests {

    /**
     * The repository's layer object
     */

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void before() {
        roleRepository.deleteAll();
    }

    /**
     * The test-method for same-named repository's default method that get one entity by ID.
     */
    @Test
    public void testSaveGetRole() {
        Role actual = createNewRole();
        roleRepository.save(actual);
        roleRepository.flush();

        Role obtained = roleRepository.findById(actual.getId()).get();

        Assert.assertEquals(actual, obtained);
    }

    /**
     * The test-method for findOne repository's default method that get one entity by ID=null.
     */
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void sendNullId() {

        Long id = null;
        roleRepository.findById(id).get();
    }

    public Role createNewRole() {
        Role role = new Role();
        role.setRoleName(UserRole.ROLE_EMPLOYEE);
        return role;
    }
}