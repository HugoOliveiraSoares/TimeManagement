package com.hugooliveirasoares.timemanagement.service;

import com.hugooliveirasoares.timemanagement.dao.ActivityDAO;
import com.hugooliveirasoares.timemanagement.domain.Activity;
import com.hugooliveirasoares.timemanagement.domain.ActivityList;

import java.util.List;

public class Service {

    ActivityList activityList = new ActivityList();

    public void saveActivity(Activity activity){
        ActivityDAO dao = new ActivityDAO();
        dao.save(activity);
//        activityList.getListActivity().add(activity);
    }

    public List<Activity> getActivities(){
        ActivityDAO dao = new ActivityDAO();
        return dao.read();
    }

    public ActivityList getActivityList() {
        return activityList;
    }
}
