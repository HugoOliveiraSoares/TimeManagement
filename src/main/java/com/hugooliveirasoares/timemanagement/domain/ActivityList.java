package com.hugooliveirasoares.timemanagement.domain;

import java.util.ArrayList;
import java.util.List;

public class ActivityList {

    List<Activity> listActivity = new ArrayList<>();

    public List<Activity> getListActivity() {
        return listActivity;
    }

    public void setListActivity(List<Activity> listActivity) {
        this.listActivity = listActivity;
    }
}
