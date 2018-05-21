package com.javanine.finalProject.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:payment.properties")
@ConfigurationProperties(prefix = "payment.coefficient")
@Data
@NoArgsConstructor
public class EventTypeCoefficientProperties {
}
