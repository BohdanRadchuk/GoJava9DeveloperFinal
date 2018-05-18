package com.javanine.finalProject.service;

import com.javanine.finalProject.model.WorkingDay;
import java.util.Date;
import java.util.List;

public interface WorkingDayService extends ModelService<WorkingDay, Long> {
    List<WorkingDay> findByEmployee(Long employeeId, Date startDate, Date endDate);
}
