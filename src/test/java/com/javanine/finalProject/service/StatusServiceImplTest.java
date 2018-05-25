package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.model.enums.EmployeeStatus;
import com.javanine.finalProject.repository.StatusRepository;
import com.javanine.finalProject.service.impl.StatusServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class StatusServiceImplTest {

    @TestConfiguration
    static class StatusServiceImplTestContextConfiguration {

        @Bean
        public StatusService statusService() {
            return new StatusServiceImpl();
        }
    }

    @Autowired
    private StatusService statusService;

    @MockBean
    private StatusRepository statusRepository;

    @Test
    public void saveNull(){
        trySaveStatus(null);
    }

    @Test
    public void save()  {
        Status status = new Status();
        status.setStatusName(EmployeeStatus.HOLIDAY);
        trySaveStatus(status);
    }

    @Test
    public void deleteNullID() {
        tryDeleteStatus(null);
    }

    @Test
    public void deleteStatus() {
        tryDeleteStatus(0L);
    }

    private void trySaveStatus(Status status) {
        Mockito.when(statusRepository.save(status)).thenReturn(status);
        statusService.save(status);
        Mockito.verify(statusRepository, times(1)).save(status);
    }

    private void tryDeleteStatus(Long id) {
        Mockito.doNothing().when(statusRepository).deleteById(id);
        statusService.deleteById(id);
        Mockito.verify(statusRepository, times(1)).deleteById(id);
    }
}
