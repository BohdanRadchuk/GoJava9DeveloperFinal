package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.WorkingDayDTO;
import com.javanine.finalProject.model.WorkingDay;
import java.util.Date;
import java.util.List;

public interface WorkingDayService extends ModelService<WorkingDayDTO, WorkingDay, Long> {

    List<WorkingDayDTO> findByEmployee(Long employeeId, Date startDate, Date endDate);
}
