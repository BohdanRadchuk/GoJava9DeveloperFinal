package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.*;
import com.javanine.finalProject.model.enums.UserRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EmployeeTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void before (){
        employeeRepository.deleteAll();
        userRepository.deleteAll();
        positionRepository.deleteAll();
        departmentRepository.deleteAll();

        roleRepository.deleteAll();
    }

    @Test
    public void deleteEmployee() {
        List<Employee> employees;
        employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            Employee newEmpl = createNewEmployee();
            employeeRepository.save(newEmpl);
            employees = employeeRepository.findAll();
        }

        Employee employee = employees.get(employees.size() - 1);
        long idForDelete = employee.getId();
        employeeRepository.delete(employee);
        employeeRepository.flush();
        Optional<Employee> obtained = employeeRepository.findById(idForDelete);

        Assert.assertFalse(obtained.isPresent());
    }

    private Employee createNewEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("TestFirstName");
        employee.setLastName("TestLastName");
        Department department = new Department();
        department.setName("Department 1");
        departmentRepository.save(department);
        departmentRepository.flush();


        Position position = new Position();

        position.setName("TestPosition");
        position.setDepartmentId(department.getId());
        positionRepository.save(position);
        positionRepository.flush();

        User user = new User();
        user.setEmail("email@sobaka.com");
        user.setPassword("pass");

        Role role = new Role();
        role.setRoleName(UserRole.ROLE_EMPLOYEE);
        roleRepository.save(role);


        ArrayList<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        userRepository.flush();

        employee.setDepartmentId(1L);
        employee.setPositionId(1L);
        employee.setHourlyRate(BigDecimal.valueOf(50.32));
        employee.setUserId(1L);
        return employee;
    }

}
