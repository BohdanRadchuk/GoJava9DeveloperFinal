package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.model.Position;
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
public class PositionTests {

    /**
     * The repository's layer object
     */

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Before
    public void before() {
        positionRepository.deleteAll();
    }

    /**
     * The test-method for same-named repository's default method that get one entity by ID.
     */
    @Test
    public void testSaveGetPosition() {
        Position actual = createNewPosition();

        positionRepository.save(actual);
        positionRepository.flush();

        Position obtained = positionRepository.findById(actual.getId()).get();

        Assert.assertEquals(actual, obtained);
    }

    /**
     * The test-method for findOne repository's default method that get one entity by ID=null.
     */
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void sendNullId() {

        Long id = null;
        positionRepository.findById(id).get();
    }

    public Position createNewPosition() {
        Position position = new Position();
        Department department = createNewDepartment();
        departmentRepository.save(department);
        position.setName("TestPosition");
        position.setDepartmentId(department.getId());
        return position;
    }

    public Department createNewDepartment() {
        Department department = new Department();
        department.setName("Department 1");
        return department;
    }

}
