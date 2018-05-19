package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Position;

public interface PositionService extends ModelService<Position, Long> {
    Position findByName(String name);
}
