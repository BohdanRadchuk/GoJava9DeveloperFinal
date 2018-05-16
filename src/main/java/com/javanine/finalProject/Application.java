package com.javanine.finalProject;

import com.javanine.finalProject.service.impl.DepartmentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FinalProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
		DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
		System.out.println(departmentService.findByName("HR"));
	}
}
