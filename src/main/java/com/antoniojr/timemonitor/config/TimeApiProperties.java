package com.antoniojr.timemonitor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
@ConfigurationProperties(prefix = "time-api")
@Validated
public record TimeApiProperties(

    @NotBlank String baseUrl,

    @NotBlank String rapidApiKey,

    @NotBlank String rapidApiHost,

    @NotBlank String timezone,

    @NotBlank String continent,

    @NotBlank String city

) {
}
