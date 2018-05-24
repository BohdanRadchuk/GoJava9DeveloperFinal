package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EmployeeTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveGetEmployee() {
        Employee actual = createNewEmployee();
        employeeRepository.save(actual);
        Employee obtained = employeeRepository.findById(actual.getId()).get();

        Assert.assertEquals(actual, obtained);
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
        employee.setDepartmentId(1L);
        employee.setPositionId(1L);
        employee.setHourlyRate(BigDecimal.valueOf(50.32));
        employee.setUserId(1L);
        return employee;
    }
}
