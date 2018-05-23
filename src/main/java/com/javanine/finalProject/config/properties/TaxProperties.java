package com.javanine.finalProject.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.math.BigDecimal;

@Configuration
@PropertySource("classpath:payment.properties")
@ConfigurationProperties(prefix = "tax")
@Data
@NoArgsConstructor
public class TaxProperties {
    private BigDecimal personalIncomeTax;
    private BigDecimal militaryTax;
}
