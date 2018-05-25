package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;

/**
 * Interface for service's layer of Position.Extends CRUD methods from {@link com.javanine.finalProject.service.ModelService}
 */
public interface PositionService extends ModelService<PositionDTO, Position, Long> {
    /**
     * Get position by name
     * @param name - name
     * @return position
     */
    PositionDTO findByName(String name);
}
