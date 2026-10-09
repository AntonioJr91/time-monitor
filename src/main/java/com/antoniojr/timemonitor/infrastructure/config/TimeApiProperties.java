package com.antoniojr.timemonitor.infrastructure.config;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "time-api")
@Validated
public record TimeApiProperties(
        @NotBlank String baseUrl,
        @NotBlank String rapidApiKey,
        @NotBlank String rapidApiHost,
        @NotBlank String continent,
        @NotBlank String city
) {
}
