package com.hugooliveirasoares.timemanagement.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Activity {

    private String information;
    private String startTime;
    private String endTime;
    private String duration;
    private String task;

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTimeSpent() {
        return duration;
    }

    public void setTimeSpent(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        duration = String.valueOf(calculateTimeSpent(startTime, endTime));
    }

    private long calculateTimeSpent(String startTime, String endTime){

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar hour1 = new GregorianCalendar();
        Calendar hour2 = new GregorianCalendar();
        Date init = null;
        Date end = null;
        long duration;

        try {
            init = dateFormat.parse(startTime);
            end = dateFormat.parse(endTime);

        }catch (ParseException e){
            e.printStackTrace();
        }

        hour1.setTime(init);
        hour2.setTime(end);

        duration = (hour2.getTime()).getTime() - (hour1.getTime()).getTime();
        return duration / (60*1000);
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
