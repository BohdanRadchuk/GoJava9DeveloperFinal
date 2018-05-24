package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.dto.WorkingDayDTO;
import com.javanine.finalProject.model.WorkingDay;
import com.javanine.finalProject.repository.EmployeeRepository;
import com.javanine.finalProject.repository.EventRepository;
import com.javanine.finalProject.repository.StatusRepository;
import com.javanine.finalProject.repository.WorkingDayRepository;
import com.javanine.finalProject.service.WorkingDayService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import static org.springframework.util.Assert.notNull;

/**
 * Service layer {@link WorkingDay,WorkingDayService}
 */
@Slf4j
@Transactional
@Service
public class WorkingDayServiceImpl implements WorkingDayService {

    @Autowired
    private WorkingDayRepository workingDayRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private EventRepository eventRepository;

    /**
     * The method calls repository's method to save workingDay
     * @param workingDay - workingDay
     * @return saved workingDay
     */
    @Override
    public WorkingDayDTO save(WorkingDay workingDay) {
        notNull(workingDay, "workingDay is null");
        final WorkingDay saved = workingDayRepository.save(workingDay);
        log.info("WorkingDay created");
        return findById(saved.getId());
    }

    /**
     * The method calls repository's method to get workingDay by id using {@link EventDTO,StatusDTO,EmployeeDTO}
     * @param id - id
     * @return workingDayDTO
     */
    @Override
    public WorkingDayDTO findById(Long id) {
        notNull(id, "id is null");
        val workingDayDTO = new WorkingDayDTO();
        final WorkingDay workingDay = workingDayRepository.getOne(id);

        final EventDTO eventDTO = eventRepository.findInId(workingDay.getEmployeeId());
        final StatusDTO statusDTO = statusRepository.findInId(workingDay.getStatusId());
        final EmployeeDTO employeeDTO = employeeRepository.findInId(workingDay.getEmployeeId());

        workingDayDTO.setId(workingDay.getId());
        workingDayDTO.setDate(workingDay.getDate());
        workingDayDTO.setEvent(eventDTO);
        workingDayDTO.setStatus(statusDTO);
        workingDayDTO.setEmployee(employeeDTO);
        workingDayDTO.setHours(workingDay.getHours());
        log.info("Found working day");
        return workingDayDTO;
    }

    /**
     * The method calls repository's method to get list of workingDays
     * @param page - page, count starts from 0
     * @param limit - page limit
     * @return list
     */
    @Override
    public List<WorkingDayDTO> findAll(int page, int limit) {
        final List<WorkingDay> dayList = workingDayRepository.findAll(PageRequest.of(page, limit)).getContent();
        List<WorkingDayDTO> list = new LinkedList<>();
        for (WorkingDay elem : dayList) {
            final WorkingDayDTO workingDayDTO = new WorkingDayDTO();
            final EventDTO eventDTO = eventRepository.findInId(elem.getEmployeeId());
            final StatusDTO statusDTO = statusRepository.findInId(elem.getStatusId());
            final EmployeeDTO employeeDTO = employeeRepository.findInId(elem.getEmployeeId());

            workingDayDTO.setId(elem.getId());
            workingDayDTO.setDate(elem.getDate());
            workingDayDTO.setEvent(eventDTO);
            workingDayDTO.setStatus(statusDTO);
            workingDayDTO.setEmployee(employeeDTO);
            workingDayDTO.setHours(elem.getHours());

            list.add(workingDayDTO);
        }
        log.info("Found all working days");
        return list;
    }

    /**
     * The method calls repository's method to update workingDay
     * @param workingDay - workingDay
     * @return updated workingDay
     */
    @Override
    public WorkingDayDTO update(WorkingDay workingDay) {
        notNull(workingDay, "working day is null");
        final WorkingDay updated = workingDayRepository.saveAndFlush(workingDay);
        log.info("Working day created");
        return findById(updated.getId());
    }

    /**
     * The method calls repository's method to delete workingDay
     * @param id - id
     */
    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("Working day deleted");
        workingDayRepository.deleteById(id);
    }

    /**
     * The method calls repository's method to get workingDay by employee
     * @param employeeId - employee Id
     * @param startDate - start Date
     * @param endDate - end Date
     * @return list
     */
    @Override
    public List<WorkingDayDTO> findByEmployee(Long employeeId, Date startDate, Date endDate) {
        notNull(employeeId, "employee id is null");
        notNull(startDate, "start date is null");
        notNull(endDate, "end date is null");
        final List<Long> days = workingDayRepository.findByEmployee(employeeId, startDate, endDate);
        List<WorkingDayDTO> list = new LinkedList<>();
        for (Long elem : days) {
            list.add(findById(elem));
        }
        log.info("Employee`s working days");
        return list;
    }
}
