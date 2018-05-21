package com.javanine.finalProject;

import com.javanine.finalProject.config.properties.EventTypeCoefficientProperties;
import com.javanine.finalProject.config.properties.SickLeaveCoefficientProperties;
import com.javanine.finalProject.config.properties.TaxProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FinalProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
		System.out.println(new TaxProperties());
		System.out.println(new SickLeaveCoefficientProperties());
		System.out.println(new EventTypeCoefficientProperties());
	}
}
