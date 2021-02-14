package com.hugooliveirasoares.timemanagement.controller;

import com.hugooliveirasoares.timemanagement.domain.Activity;
import com.hugooliveirasoares.timemanagement.domain.ActivityList;
import com.hugooliveirasoares.timemanagement.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    Service service = new Service();

    @GetMapping("/")
    public String getDate(){
        return new Date().toString();
    }

    @GetMapping("/getactivity")
    public List<Activity> getActivity(){
        return service.getActivities();
    }

    @GetMapping("/getbytask")
    public List<Activity> getbyTask(@RequestParam String id){
        return service.getActivityList().getbyTask(id);
    }


    @PostMapping("/postactivity")
    public String postactivity(@RequestBody Activity activity){

        return service.saveActivity(activity);
    }

}
