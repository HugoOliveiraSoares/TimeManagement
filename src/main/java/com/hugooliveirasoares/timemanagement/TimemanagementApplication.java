package com.hugooliveirasoares.timemanagement;

import com.hugooliveirasoares.timemanagement.dao.ActivityDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class TimemanagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TimemanagementApplication.class, args);

		ActivityDAO activityDAO = new ActivityDAO();
		activityDAO.connection();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TimemanagementApplication.class);
	}
}
