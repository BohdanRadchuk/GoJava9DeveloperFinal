package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.repository.EmployeeRepository;
import com.javanine.finalProject.service.impl.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EmployeeServiceImpTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test(expected = EntityNotFoundException.class)
    public void saveWithoutExistingUser(){
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Smith");
        employee.setDepartmentId(1L);
        employee.setPositionId(1L);
        employee.setHourlyRate(new BigDecimal(1000));
        employee.setUserId(10L);

        when(employeeRepository.save(employee)).thenReturn(employee);
        employeeService.save(employee);
        verify(employeeRepository, times(1)).save(employee);
    }
}
