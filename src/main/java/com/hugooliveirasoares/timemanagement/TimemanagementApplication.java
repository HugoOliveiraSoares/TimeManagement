package com.hugooliveirasoares.timemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TimemanagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TimemanagementApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TimemanagementApplication.class);
	}
}
