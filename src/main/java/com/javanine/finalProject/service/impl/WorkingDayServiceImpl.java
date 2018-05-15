package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.WorkingDay;
import com.javanine.finalProject.repository.WorkingDayRepository;
import com.javanine.finalProject.service.WorkingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkingDayServiceImpl implements WorkingDayService {
    @Autowired
    private WorkingDayRepository workingDayRepository;

    @Override
    public void save(WorkingDay workingDay) {
        workingDayRepository.save(workingDay);
    }

    @Override
    public WorkingDay findById(Long id) {
        if (workingDayRepository.findById(id).isPresent())
            return workingDayRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<WorkingDay> findAll() {
        return workingDayRepository.findAll();
    }

    @Override
    public void update(WorkingDay workingDay) {

    }

    @Override
    public void deleteById(Long id) {
        workingDayRepository.deleteById(id);
    }



    @Override
    public List<WorkingDay> findByEmployee(Employee employee, int year, int month) {
        return null;
    }
}
