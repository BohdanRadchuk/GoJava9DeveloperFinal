package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.model.enums.EmployeeStatus;
import com.javanine.finalProject.repository.StatusRepository;
import com.javanine.finalProject.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public Status findById(Long id) {
        return statusRepository.getOne(id);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public void update(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }


}