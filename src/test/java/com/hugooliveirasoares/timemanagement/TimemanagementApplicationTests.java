package com.hugooliveirasoares.timemanagement;

import com.hugooliveirasoares.timemanagement.controller.Controller;
import com.hugooliveirasoares.timemanagement.dao.ActivityDAO;
import com.hugooliveirasoares.timemanagement.domain.Activity;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TimemanagementApplicationTests {

	@Mock
	final private Controller mockedController = mock(Controller.class);

	@Mock
	final private ActivityDAO mockedDao = mock(ActivityDAO.class);

	@InjectMocks
	final private Activity activity = new Activity();

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

	@Test
	public void databaseSaveTrueTest(){

		activity.setTask("Testing Database");
		activity.setTimeSpent("09:00", "10:00");
		activity.setInformation("Test save");

		when(mockedDao.save(activity))
				.thenReturn(true);

	}

	@Test
	public void databaseReadTest(){

		activity.setTask("Test Database");
		activity.setTimeSpent("09:57", "10:30");
		activity.setInformation("Testing database");

		List<Activity> listActivity = new ArrayList<>();
		listActivity.add(activity);

		mockedDao.save(activity);

		when(mockedDao.read())
				.thenReturn(listActivity);
	}

}
