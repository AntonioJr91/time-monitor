package com.antoniojr.timemonitor.scheduler;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.antoniojr.timemonitor.service.TimeApiService;

@Component
public class TimeApiScheduler {

  private final TimeApiService timeApiService;

  public TimeApiScheduler(TimeApiService timeApiService) {
    this.timeApiService = timeApiService;
  }

  @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
  public void fetchTime() {
    System.out.println("===> Scheduler executado");

    String response = timeApiService.getTime();

    System.out.println(response);
  }
}