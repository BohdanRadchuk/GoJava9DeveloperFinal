package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.repository.PositionRepository;
import com.javanine.finalProject.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;
@Slf4j
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public PositionDTO findByName(String name) {
        hasText(name, "name is null");
        log.info("Found position by name");
        return positionRepository.findByName(name);
    }

    @Override
    public PositionDTO save(Position position) {
        notNull(position, "position is null");
        final Position savedPosition = positionRepository.save(position);
        log.info("Saved position");
        return positionRepository.findInId(savedPosition.getId());
    }

    @Override
    public PositionDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("Found position by id");
        return positionRepository.findInId(id);
    }

    @Override
    public List<PositionDTO> findAll(int page, int limit) {
        log.info("Found all positions");
        return positionRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public PositionDTO update(Position position) {
        notNull(position, "position is null");
        final Position saved = positionRepository.saveAndFlush(position);
        log.info("Updated position");
        return positionRepository.findInId(saved.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("deleted position");
        positionRepository.deleteById(id);
    }
}
