package com.hugooliveirasoares.timemanagement;

import com.hugooliveirasoares.timemanagement.controller.Controller;
import com.hugooliveirasoares.timemanagement.domain.Activity;
import com.hugooliveirasoares.timemanagement.domain.ActivityList;
import com.hugooliveirasoares.timemanagement.service.Service;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TimemanagementApplicationTests {

	@Mock
	private Controller mockedController = mock(Controller.class);

	@InjectMocks
	private Service service;

	@InjectMocks
	private Activity activity = new Activity();

	@InjectMocks
	private ActivityList activityList;

	@BeforeEach
	public void setup(){
		standaloneSetup(this.mockedController);
	}

	@Test
	public void ControllerTest(){

		activity.setTask("A");
		activity.setTimeSpent("09:00", "10:00");
		activity.setInformation("Teste");

		mockedController.getDate();
		mockedController.getActivity();
		mockedController.getbyTask("A");
		mockedController.postactivity(activity);

		verify(mockedController).getDate();
		verify(mockedController).getActivity();
		verify(mockedController).getbyTask("A");
		verify(mockedController).postactivity(activity);
	}

	@Test
	public void postactivityTest(){

		activity.setTask("B");
		activity.setTimeSpent("09:00", "10:30");
		activity.setInformation("Teste");

		when(mockedController.postactivity(activity))
				.thenReturn("90");

		assertEquals(activity.getTimeSpent(), mockedController.postactivity(activity));
	}


}
