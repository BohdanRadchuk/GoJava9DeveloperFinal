package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;
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
import static org.mockito.Mockito.times;
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

    @Test
    public void saveNull(){
        trySaveDepartment(null);
    }

    @Test
    public void save()  {
        Department department = new Department();
        department.setName("New Department");
        trySaveDepartment(department);
    }

    @Test
    public void deleteNullID() {
        tryDeleteDepartment(null);
    }

    @Test
    public void deleteDepartment() {
        tryDeleteDepartment(0L);
    }

    private void trySaveDepartment(Department department) {
        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        departmentService.save(department);
        Mockito.verify(departmentRepository, times(1)).save(department);
    }

    private void tryDeleteDepartment(Long id) {
        Mockito.doNothing().when(departmentRepository).deleteById(id);
        departmentService.deleteById(id);
        Mockito.verify(departmentRepository, times(1)).deleteById(id);
    }
}
