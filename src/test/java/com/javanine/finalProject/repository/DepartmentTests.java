package com.javanine.finalProject.repository;


import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.repository.DepartmentRepository;
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
public class DepartmentTests {


    /**
     * The repository's layer object
     */

    @Autowired
    private DepartmentRepository departmentRepository;

    @Before
    public void before() {
        departmentRepository.deleteAll();
    }

    /**
     * The test-method for same-named repository's default method that get one entity by ID.
     */
    @Test
    public void testSaveGetDepartment() {
        Department actual = createNewDepartment();
        departmentRepository.save(actual);
        departmentRepository.flush();

        Department obtained = departmentRepository.findById(actual.getId()).get();

        Assert.assertEquals(actual, obtained);
    }

    /**
     * The test-method for findOne repository's default method that get one entity by ID=null.
     */
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void sendNullId() {

        Long id = null;
        departmentRepository.findById(id).get();
    }

    public Department createNewDepartment() {
        Department department = new Department();
        department.setName("Department 1");
        return department;
    }

}
