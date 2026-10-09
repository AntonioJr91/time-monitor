package com.antoniojr.timemonitor.application.port;

import com.antoniojr.timemonitor.application.dto.CurrentTime;

public interface TimeApiPort {
   CurrentTime getCurrentTime();
}
