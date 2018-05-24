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
import com.javanine.finalProject.utils.LettersExample;
import com.javanine.finalProject.utils.PDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.File;
import java.util.List;

@Component
@Configuration
@EnableScheduling
public class ScheduleTask {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private CountServiceImpl countService;

    /*   @Autowired
       private SettlementSheet settlementSheet;*/
    @Autowired
    private EmployeeService employeeRepository;


    @Autowired
    private SettlementSheetService settlementSheetService;

    @Autowired
    private UserRepository userRepository;

    //testing
    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 10000);
//        EmailServiceImpl emailService = new EmailServiceImpl();
        //emailService.sendSimpleMessage("jano.ssh@gmail.com", "test", "some text");
        scheduleTaskUsingCronExpression();
    }


    //running first day every month
    @Scheduled(cron = "1 0 0 1 * ?") //https://www.freeformatter.com/cron-expression-generator-quartz.html
    public void scheduleTaskUsingCronExpression() {

        List<EmployeeDTO> employeesList = employeeRepository.findAll(1,7);
        for (EmployeeDTO employees : employeesList) {
            SettlementSheet employeeSheet = countService.calculateEmployeeSheet(employees);
            //save archive salary

            settlementSheetService.save(employeeSheet);

            //send email

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
