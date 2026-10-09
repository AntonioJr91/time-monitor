package com.antoniojr.timemonitor.infrastructure.config;

import com.antoniojr.timemonitor.application.port.TimeApiPort;
import com.antoniojr.timemonitor.application.usecase.TimeApiService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TimeApiProperties.class)
public class TimeApiConfiguration {

    @Bean
    TimeApiService timeApiService(TimeApiPort timeApiPort) {
        return new TimeApiService(timeApiPort);
    }
}
