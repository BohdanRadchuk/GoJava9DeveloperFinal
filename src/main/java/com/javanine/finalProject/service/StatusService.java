package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.model.Status;

public interface StatusService extends ModelService<Status, Long> {
    StatusDTO findDto(Long id);
}
