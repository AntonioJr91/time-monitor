package com.antoniojr.timemonitor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.antoniojr.timemonitor.config.TimeApiProperties;

@Service
public class TimeApiService {
  private final RestClient restClient;
  private final TimeApiProperties timeApiProperties;

  public TimeApiService(
      RestClient.Builder restClientBuilder,
      TimeApiProperties timeApiProperties) {
    this.restClient = restClientBuilder
        .baseUrl(timeApiProperties.baseUrl())
        .build();

    this.timeApiProperties = timeApiProperties;
  }

  public String getTime() {
    return restClient
        .get()
        .uri(uriBuilder -> uriBuilder
            .pathSegment(
                timeApiProperties.timezone(),
                timeApiProperties.continent(),
                timeApiProperties.city())
            .build())
        .header("x-rapidapi-key", timeApiProperties.rapidApiKey())
        .header("x-rapidapi-host", timeApiProperties.rapidApiHost())
        .retrieve()
        .body(String.class);
  }

}
