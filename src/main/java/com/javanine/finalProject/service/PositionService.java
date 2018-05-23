package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;

public interface PositionService extends ModelService<PositionDTO, Position, Long> {

    PositionDTO findByName(String name);
}
