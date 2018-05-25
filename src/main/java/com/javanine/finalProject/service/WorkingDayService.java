package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.WorkingDayDTO;
import com.javanine.finalProject.model.WorkingDay;
import java.util.Date;
import java.util.List;

/**
 * Interface for service's layer of Working day.Extends CRUD methods from {@link com.javanine.finalProject.service.ModelService}
 */
public interface WorkingDayService extends ModelService<WorkingDayDTO, WorkingDay, Long> {
    /**
     * Get list of working days.
     * @param employeeId - id of employee
     * @param startDate - start date
     * @param endDate - end date
     * @return list
     */
    List<WorkingDayDTO> findByEmployee(Long employeeId, Date startDate, Date endDate);
}
