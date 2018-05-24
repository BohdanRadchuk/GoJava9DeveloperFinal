package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.repository.StatusRepository;
import com.javanine.finalProject.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;
@Slf4j
@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public StatusDTO save(Status status) {
        notNull(status, "status is null");
        final Status saved = statusRepository.save(status);
        log.info("Status created");
        return statusRepository.findInId(saved.getId());
    }

    @Override
    public StatusDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("Status found");
        return statusRepository.findInId(id);
    }

    @Override
    public List<StatusDTO> findAll(int page, int limit) {
        log.info("Got all statuses");
        return statusRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public StatusDTO update(Status status) {
        notNull(status, "status is null");
        final Status saved = statusRepository.saveAndFlush(status);
        log.info("Status updated");
        return statusRepository.findInId(saved.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("Status deleted");
        statusRepository.deleteById(id);
    }
}
