package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.repository.PositionRepository;
import com.javanine.finalProject.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position findByName(String name) {
        return positionRepository.findByName(name);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.getOne(id);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void update(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public PositionDTO findDto(Long id) {
        return positionRepository.findDto(id);
    }
}
