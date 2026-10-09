package com.antoniojr.timemonitor.infrastructure.adapter.in;

import com.antoniojr.timemonitor.application.dto.CurrentTime;
import com.antoniojr.timemonitor.application.usecase.TimeApiService;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Component
public class TimeApiScheduler {
   private static final Logger LOGGER = LoggerFactory.getLogger(TimeApiScheduler.class);

   private final TimeApiService timeApiService;
   private final ObjectMapper objectMapper;

   public TimeApiScheduler(TimeApiService timeApiService, ObjectMapper objectMapper) {
      this.timeApiService = timeApiService;
      this.objectMapper = objectMapper;
   }

   @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
   public void fetchTime() throws JacksonException {
      CurrentTime response = timeApiService.execute();
      LOGGER.info("Time API response: {}", objectMapper.writeValueAsString(response));
   }
}
