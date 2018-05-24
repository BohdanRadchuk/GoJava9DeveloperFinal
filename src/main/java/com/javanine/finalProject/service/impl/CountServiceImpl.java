package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.config.properties.EventTypeCoefficientProperties;
import com.javanine.finalProject.dto.WorkingDayDTO;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.SettlementSheet;
import com.javanine.finalProject.repository.SettlementSheetRepository;
import com.javanine.finalProject.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Autowired
    SettlementSheetRepository settlementSheet;

    @Override
    public SettlementSheet calculateEmployeeSheet(Employee employees) {

        Calendar myCal = Calendar.getInstance();
        myCal.add(Calendar.MONTH, -1);
        myCal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = myCal.getTime();

        int dayInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        myCal.set(Calendar.DAY_OF_MONTH, dayInMonth);
        Date endDate = myCal.getTime();
        System.out.println(startDate + " startdate");
        System.out.println(endDate + " enddate");
        System.out.println(employees);
        System.out.println(employees.getId() + "id");

        List<WorkingDayDTO> list = workingDayService.findByEmployee(employees.getId(), startDate, endDate);


        System.out.println(list + "LIST");
        int workingHours = 0;
        int holidayHours = 0;
        int hospitalHours = 0;
        SettlementSheet employeeSheet = new SettlementSheet();
        BigDecimal salary;

        if (!list.isEmpty()) {
            for (WorkingDayDTO wh : list) {

                if (wh.getStatus().getStatusName().equals("HOSPITAL")) {
                    if (wh.getStatus().getStatusName().equals("HOSPITAL")) {
                        if (wh.getEvent().getEventName().equals("WORKING_DAY")) {
                            hospitalHours += eventTypeCoefficientProperties.getWorkingDay().multiply(new BigDecimal(wh.getHours())).intValue();
                        } else {
                            hospitalHours += eventTypeCoefficientProperties.getTechnicalStudies().multiply(new BigDecimal(wh.getHours())).intValue();
                        }
                    } else if (wh.getStatus().getStatusName().equals("WORKING")) {
                        if (wh.getEvent().getEventName().equals("WORKING_DAY")) {
                            workingHours += eventTypeCoefficientProperties.getWorkingDay().multiply(new BigDecimal(wh.getHours())).intValue();
                        } else {
                            workingHours += eventTypeCoefficientProperties.getTechnicalStudies().multiply(new BigDecimal(wh.getHours())).intValue();
                        }
                    } else if (wh.getStatus().getStatusName().equals("HOLIDAY")) {
                        if (wh.getEvent().getEventName().equals("WORKING_DAY")) {
                            holidayHours += eventTypeCoefficientProperties.getWorkingDay().multiply(new BigDecimal(wh.getHours())).intValue();
                        } else {
                            holidayHours += eventTypeCoefficientProperties.getTechnicalStudies().multiply(new BigDecimal(wh.getHours())).intValue();
                        }
                    }
                }
            }

        }
        salary = new BigDecimal(workingHours + holidayHours + hospitalHours).multiply(employees.getHourlyRate());

        employeeSheet.setEmployeeId(employees.getId());
        employeeSheet.setMonth(startDate.getMonth());
        employeeSheet.setMonth(startDate.getYear());
        employeeSheet.setWorkingHours(workingHours);
        employeeSheet.setHolidayHours(holidayHours);
        employeeSheet.setHospitalHours(hospitalHours);
        employeeSheet.setSalary(salary);

        return employeeSheet;
    }
}
