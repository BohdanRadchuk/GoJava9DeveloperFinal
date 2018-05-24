package com.javanine.finalProject.utils;


import com.javanine.finalProject.model.SettlementSheet;
import com.javanine.finalProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;

public class LettersExample {

    /**
     * create message for employee's month salary
     * @param employeeSheet - employee sheet
     * @return - employee sheet like message
     */

    @Autowired
    private EmployeeService employeeService;

    public String createSalaryMessage(SettlementSheet employeeSheet){

        SimpleDateFormat format = new SimpleDateFormat("MMMM  yyyy");
        String message = "<p>Dear, "+ employeeService.findById(employeeSheet.getEmployeeId()).getFirstName()+" "+employeeService.findById(employeeSheet.getEmployeeId()).getLastName()+"</p>";
        message += "<p>Your total salary for "+format.format(employeeSheet.getMonth())+ format.format(employeeSheet.getYear())+ " is: "+employeeSheet.getSalary()+"</p>";
        message += "<p><div>Your statistic:</div><ol>";
        message += "<li>"+ " WorkingHours -- "+" total hours is "+employeeSheet.getWorkingHours()+"</li>";
        message += "<li>"+ " HospitalHours -- "+" total hours is "+employeeSheet.getHospitalHours()+"</li>";
        message += "<li>"+ " HolidayHours -- "+" total hours is "+employeeSheet.getHolidayHours()+"</li>";
        message +="</ol></p>";

        message +="</ol></p>";
        return message;
    }


}
