package com.travel.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // This method defines the RestTemplate bean for Spring Boot to use
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
