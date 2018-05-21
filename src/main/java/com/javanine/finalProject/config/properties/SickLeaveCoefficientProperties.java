package com.javanine.finalProject.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.math.BigDecimal;

@Configuration
@PropertySource("classpath:payment.properties")
@ConfigurationProperties(prefix = "sick.coefficient")
@Data
@NoArgsConstructor
public class SickLeaveCoefficientProperties {
    private BigDecimal toThreeYear;
    private BigDecimal toFiveYear;
    private BigDecimal toEightYear;
    private BigDecimal fromEightYear;
}
