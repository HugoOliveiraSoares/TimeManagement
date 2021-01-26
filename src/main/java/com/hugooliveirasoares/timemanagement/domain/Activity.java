package com.hugooliveirasoares.timemanagement.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Activity {

    private int id;
    private String information;
    private String startTime;
    private String endTime;
    private String duration;
    private String task;
    private Date date;

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
        setDuration( String.valueOf(calculateTimeSpent(startTime, endTime)));
    }

    private long calculateTimeSpent(String startTime, String endTime){

        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        Calendar hour1 = new GregorianCalendar();
        Calendar hour2 = new GregorianCalendar();
        Date init = null;
        Date end = null;
        long duration;

        try {
            init = hourFormat.parse(startTime);
            end = hourFormat.parse(endTime);

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

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public void setDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
