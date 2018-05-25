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

/**
 * Service layer {@link StatusService}
 */

@Slf4j
@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    /**
     * The method calls repository's method to save status
     * @param status - status
     * @return saved status
     */
    @Override
    public StatusDTO save(Status status) {
        notNull(status, "status is null");
        final Status saved = statusRepository.save(status);
        log.info("Status created");
        return statusRepository.findInId(saved.getId());
    }

    /**
     * The method calls repository's method to get status by id
     * @param id - id
     * @return id status
     */
    @Override
    public StatusDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("Status found");
        return statusRepository.findInId(id);
    }

    /**
     * The method calls repository's method to get list of statuses
     * @param page - page, count starts from 0
     * @param limit - limit of pages
     * @return list
     */
    @Override
    public List<StatusDTO> findAll(int page, int limit) {
        log.info("Got all statuses");
        return statusRepository.findAllDto(PageRequest.of(page, limit));
    }

    /**
     * The method calls repository's method to update status
     * @param status - status
     * @return saved status
     */
    @Override
    public StatusDTO update(Status status) {
        notNull(status, "status is null");
        final Status saved = statusRepository.saveAndFlush(status);
        log.info("Status updated");
        return statusRepository.findInId(saved.getId());
    }

    /**
     * The method calls repository's method to delete status
     * @param id - id
     */
    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("Status deleted");
        statusRepository.deleteById(id);
    }
}
