package com.hugooliveirasoares.timemanagement.service;

import com.hugooliveirasoares.timemanagement.domain.Activity;
import com.hugooliveirasoares.timemanagement.domain.ActivityList;

import java.util.List;

public class Service {

    ActivityList activityList = new ActivityList();

    public void saveActivity(Activity activity){

        activityList.getListActivity().add(activity);
    }

    public ActivityList getActivityList() {
        return activityList;
    }
}
