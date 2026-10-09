package com.antoniojr.timemonitor.infrastructure.adapter.out;

import com.antoniojr.timemonitor.application.dto.CurrentTime;
import com.antoniojr.timemonitor.application.port.TimeApiPort;
import com.antoniojr.timemonitor.infrastructure.config.TimeApiProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TimeApiAdapter implements TimeApiPort {
   private final RestClient restClient;
   private final TimeApiProperties timeApiProperties;

   public TimeApiAdapter(
           RestClient.Builder restClient,
           TimeApiProperties timeApiProperties
   ) {
      this.restClient = restClient
              .baseUrl(timeApiProperties.baseUrl())
              .build();
      this.timeApiProperties = timeApiProperties;
   }

   @Override
   public CurrentTime getCurrentTime() {
      TimeApiResponse response = restClient
              .get()
              .uri(uriBuilder -> uriBuilder
                      .pathSegment(
                              "timezone",
                              timeApiProperties.continent(),
                              timeApiProperties.city())
                      .build())
              .header("x-rapidapi-key", timeApiProperties.rapidApiKey())
              .header("x-rapidapi-host", timeApiProperties.rapidApiHost())
              .retrieve()
              .body(TimeApiResponse.class);

      return new CurrentTime(
              response.abbreviation(),
              response.datetime(),
              response.day_of_week(),
              response.day_of_year(),
              response.dst(),
              response.dst_from(),
              response.dst_offset(),
              response.dst_until(),
              response.raw_offset(),
              response.timezone(),
              response.unixtime(),
              response.utc_datetime(),
              response.utc_offset(),
              response.week_number(),
              response.client_ip()
      );
   }

}
