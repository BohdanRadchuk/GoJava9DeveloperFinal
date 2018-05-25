package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.PositionDTO;
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
import static org.assertj.core.api.Assertions.assertThat;

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
}
