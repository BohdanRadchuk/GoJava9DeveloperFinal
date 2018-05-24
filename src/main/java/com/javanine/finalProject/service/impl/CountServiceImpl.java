package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.config.properties.EventTypeCoefficientProperties;
import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.dto.WorkingDayDTO;
import com.javanine.finalProject.model.*;
import com.javanine.finalProject.model.enums.EmployeeEvent;
import com.javanine.finalProject.service.CountService;
import com.javanine.finalProject.service.WorkingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@Service
public class CountServiceImpl implements CountService {

    /**
     * Calculate month salary and create salarySheet for Employee
     *
     * @param employees - employee
     * @return - employee sheet
     */

    @Autowired
    WorkingDayServiceImpl workingDayService;
    @Autowired
    EventTypeCoefficientProperties eventTypeCoefficientProperties;

    @Override
    public SettlementSheet calculateEmployeeSheet(EmployeeDTO employees) {

        Calendar myCal = Calendar.getInstance();
        myCal.add(Calendar.MONTH, -1);
        myCal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = myCal.getTime();

        int dayInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        myCal.set(Calendar.DAY_OF_MONTH, dayInMonth);
        Date endDate = myCal.getTime();

        List<WorkingDayDTO> list = workingDayService.findByEmployee(employees.getId(), startDate, endDate);

        BigDecimal workingHours = BigDecimal.valueOf(0);
        BigDecimal holidayHours = BigDecimal.valueOf(0);
        BigDecimal hospitalHours = BigDecimal.valueOf(0);
        SettlementSheet employeeSheet = new SettlementSheet();
        for (WorkingDayDTO wh : list) {
            if (wh.getStatus().getStatusName().equals("HOSPITAL")) {
                if (wh.getEvent().getEventName().equals("WORKING_DAY")) {
                    hospitalHours.add(eventTypeCoefficientProperties.getWorkingDay()).multiply(new BigDecimal(wh.getHours()));
                } else {
                    hospitalHours.add(eventTypeCoefficientProperties.getTechnicalStudies()).multiply(new BigDecimal(wh.getHours()));
                }
            } else if (wh.getStatus().getStatusName().equals("WORKING")) {
                if (wh.getEvent().getEventName().equals("WORKING_DAY")) {
                    workingHours.add(eventTypeCoefficientProperties.getWorkingDay()).multiply(new BigDecimal(wh.getHours()));
                } else {
                    workingHours.add(eventTypeCoefficientProperties.getTechnicalStudies()).multiply(new BigDecimal(wh.getHours()));
                }
            } else if (wh.getStatus().getStatusName().equals("HOLIDAY")) {
                if (wh.getEvent().getEventName().equals("WORKING_DAY")) {
                    holidayHours.add(eventTypeCoefficientProperties.getWorkingDay()).multiply(new BigDecimal(wh.getHours()));
                } else {
                    holidayHours.add(eventTypeCoefficientProperties.getTechnicalStudies()).multiply(new BigDecimal(wh.getHours()));
                }
            }
        }


        employeeSheet.setMonth(startDate.getMonth());
        employeeSheet.setMonth(startDate.getYear());
        employeeSheet.setEmployeeId(employees.getId());
        employeeSheet.setSalary((workingHours.add(holidayHours.add(hospitalHours).multiply(employees.getHourlyRate()))));
       /* employeeSheet.setWorkingHours(workingHours);
        employeeSheet.setHolidayHours(holidayHours);
        employeeSheet.setHospitalHours(hospitalHours);*/
        return employeeSheet;
    }
}
