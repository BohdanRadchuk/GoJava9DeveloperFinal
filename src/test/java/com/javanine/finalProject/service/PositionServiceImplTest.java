package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.repository.PositionRepository;
import com.javanine.finalProject.service.impl.PositionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.EntityNotFoundException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class PositionServiceImplTest {

    @TestConfiguration
    static class PositionServiceImplTestContextConfiguration {

        @Bean
        public PositionService positionService() {
            return new PositionServiceImpl();
        }
    }

    @Autowired
    private PositionService positionService;

    @MockBean
    private PositionRepository positionRepository;

    @Before
    public void setUp() {
        PositionDTO position = new PositionDTO();
        position.setName("Recruiter");

        Mockito.when(positionRepository.findByName(position.getName()))
                .thenReturn(position);
    }

    @Test
    public void whenValidPositionName_thenPositionShouldBeFound() {
        PositionDTO position = new PositionDTO();
        position.setName("Recruiter");
        PositionDTO found = positionService.findByName("Recruiter");

        assertThat(found.getName())
                .isEqualTo("Recruiter");
    }

    @Test(expected = EntityNotFoundException.class)
    public void saveWithoutExistingDepartment(){
        Position position = new Position();
        position.setDepartmentId(10L);

        Mockito.when(positionRepository.save(position)).thenReturn(position);
        positionService.save(position);
        Mockito.verify(positionRepository, times(1)).save(position);
    }

    @Test
    public void saveNull(){
        trySavePosition(null);
    }

    @Test
    public void save()  {
        Position position = new Position();
        position.setName("New Position");
        trySavePosition(position);
    }

    @Test
    public void deleteNullID() {
        tryDeletePosition(null);
    }

    @Test
    public void deleteStatus() {
        tryDeletePosition(0L);
    }

    private void trySavePosition(Position position) {
        Mockito.when(positionRepository.save(position)).thenReturn(position);
        positionService.save(position);
        Mockito.verify(positionRepository, times(1)).save(position);
    }

    private void tryDeletePosition(Long id) {
        Mockito.doNothing().when(positionRepository).deleteById(id);
        positionService.deleteById(id);
        Mockito.verify(positionRepository, times(1)).deleteById(id);
    }
}
