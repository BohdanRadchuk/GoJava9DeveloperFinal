package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.model.Status;

/**
 * Interface for service's layer of Status. Extends CRUD methods from {@link com.javanine.finalProject.service.ModelService}
 */
public interface StatusService extends ModelService<StatusDTO, Status, Long> {
}