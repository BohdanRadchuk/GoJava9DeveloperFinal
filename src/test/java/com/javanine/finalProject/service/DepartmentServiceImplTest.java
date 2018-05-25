package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.repository.DepartmentRepository;
import com.javanine.finalProject.service.impl.DepartmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DepartmentServiceImplTest {
    
    @TestConfiguration
    static class DepartmentServiceImplTestContextConfiguration {

        @Bean
        public DepartmentService departmentService() {
            return new DepartmentServiceImpl();
        }
    }

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @Before
    public void setUp() {
        DepartmentDTO department = new DepartmentDTO();
        department.setName("HR");

        Mockito.when(departmentRepository.findByNameDto(department.getName()))
                .thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName("HR");
        DepartmentDTO found = departmentService.findByName("HR");

        assertThat(found.getName())
                .isEqualTo("HR");
    }


}
