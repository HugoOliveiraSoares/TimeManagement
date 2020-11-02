package com.hugooliveirasoares.timemanagement.controller;

import com.hugooliveirasoares.timemanagement.domain.Activity;
import com.hugooliveirasoares.timemanagement.domain.ActivityList;
import com.hugooliveirasoares.timemanagement.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {

    Service service = new Service();

    @GetMapping("/")
    public String getDate(){
        return new Date().toString();
    }

    @GetMapping("/getactivity")
    public ActivityList getActivity(){
        return service.getActivityList();
    }

    @PostMapping("/postactivity")
    public String postactivity(@RequestBody Activity activity){

        activity.setTimeSpent(activity.getStartTime(), activity.getEndTime());
        service.saveActivity(activity);
        return activity.getTimeSpent();
    }

}
