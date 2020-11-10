package com.hugooliveirasoares.timemanagement.domain;

import java.util.ArrayList;
import java.util.List;

public class ActivityList {

    List<Activity> listActivity = new ArrayList<>();

    public List<Activity> getListActivity() {
        return listActivity;
    }

    public List<Activity> getbyTask(String id){
        List<Activity> x = new ArrayList<>();
        for (int i = 0; i < listActivity.size(); i++) {
            if (listActivity.get(i).getTask().equals(id)) {
                x.add(listActivity.get(i));
            }
        }
        return x;
    }

    public void setListActivity(List<Activity> listActivity) {
        this.listActivity = listActivity;
    }
}
