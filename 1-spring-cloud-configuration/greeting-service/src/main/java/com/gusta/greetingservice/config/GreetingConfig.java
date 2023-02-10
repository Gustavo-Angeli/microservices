package com.gusta.greetingservice.config;

import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.stereotype.*;

@Component
@ConfigurationProperties("greeting-service")
@NoArgsConstructor
@Data
public class GreetingConfig {

    private String greeting;
    private String defaultValue;


}
