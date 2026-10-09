package com.antoniojr.timemonitor.application.usecase;

import com.antoniojr.timemonitor.application.dto.CurrentTime;
import com.antoniojr.timemonitor.application.port.TimeApiPort;

public class TimeApiService {
   private final TimeApiPort timeApiPort;

   public TimeApiService(TimeApiPort timeApiPort) {
      this.timeApiPort = timeApiPort;
   }

   public CurrentTime execute() {
      return timeApiPort.getCurrentTime();
   }
}
