package com.javanine.finalProject.scheduler;

import com.javanine.finalProject.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling
public class ScheduleTask {
    @Autowired
    private EmailServiceImpl emailService;

/*          //testing
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 10000);
//        EmailServiceImpl emailService = new EmailServiceImpl();
        emailService.sendSimpleMessage("jano.ssh@gmail.com", "test", "some text");
    }*/


        //running first day every month
    @Scheduled(cron = "1 0 0 1 * ?") //https://www.freeformatter.com/cron-expression-generator-quartz.html
    public void scheduleTaskUsingCronExpression() {

        //TODO Расчет и запись ЗП в базу данных
        //TODO Рассылка сообщений
    }
}
