package com.javanine.finalProject.scheduler;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.SettlementSheet;
import com.javanine.finalProject.model.User;
import com.javanine.finalProject.repository.EmployeeRepository;
import com.javanine.finalProject.repository.UserRepository;
import com.javanine.finalProject.service.EmployeeService;
import com.javanine.finalProject.service.SettlementSheetService;
import com.javanine.finalProject.service.impl.CountServiceImpl;
import com.javanine.finalProject.service.impl.EmailServiceImpl;
import com.javanine.finalProject.service.impl.EmployeeServiceImpl;
import com.javanine.finalProject.util.LettersExample;
import com.javanine.finalProject.util.PDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import java.io.File;
import java.util.List;

@Component
@EnableScheduling
public class ScheduleTask {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private CountServiceImpl countService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SettlementSheetService settlementSheetService;

    @Autowired
    private UserRepository userRepository;

    //testing
    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() {
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 10000);
        //EmailServiceImpl emailService = new EmailServiceImpl();
        //emailService.sendSimpleMessage("example@gmail.com", "test", "some text");
        scheduleTaskUsingCronExpression();
    }

    @Scheduled(cron = "1 0 0 1 * ?") //https://www.freeformatter.com/cron-expression-generator-quartz.html
    public void scheduleTaskUsingCronExpression() {
        List<Employee> employeesList = employeeRepository.findAll();
        System.out.println(employeesList);
        for (Employee employees : employeesList) {
            SettlementSheet employeeSheet = countService.calculateEmployeeSheet(employees);
            settlementSheetService.save(employeeSheet);

            User user = userRepository.findById(employees.getId()).get();
            String mail = user.getEmail();
            LettersExample lettersExample = new LettersExample();
            String sendingMessage = lettersExample.createSalaryMessage(employeeSheet);

            File file1 = PDF.createPDF("employee_" + employees.getId(), sendingMessage);
            try {
                emailService.sendMessageWithAttachment(mail, "You sheet from HRManagement", sendingMessage, file1.getPath());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
