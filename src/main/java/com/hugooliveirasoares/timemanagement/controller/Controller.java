package com.hugooliveirasoares.timemanagement.controller;

import com.hugooliveirasoares.timemanagement.domain.Activity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {

    @GetMapping("/")
    public String getDate(){
        return new Date().toString();
    }

    @GetMapping("/getactivity")
    public Activity getActivity(){
        return new Activity();
    }

    @PostMapping("/postactivity")
    public Activity postactivity(@RequestBody Activity activity){
        activity.setTime("2324");
        activity.setInformation("Hello");
        return activity;
    }

}
