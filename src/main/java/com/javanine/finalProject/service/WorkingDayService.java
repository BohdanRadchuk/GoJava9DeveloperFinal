package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.WorkingDay;
import java.util.List;

public interface WorkingDayService extends ModelService<WorkingDay, Long> {
    List<WorkingDay> findByEmployee(Employee employee, int year, int month);
}
