package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.SettlementSheet;

public interface CountService {
        /**
         * Calculate month salary and create Sheet for employee
         * @param employees - employee
         * @return - month sheet for employee
         */
        SettlementSheet calculateEmployeeSheet(EmployeeDTO employees);
}
