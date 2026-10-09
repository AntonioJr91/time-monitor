package com.antoniojr.timemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimemonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimemonitorApplication.class, args);
	}

}
