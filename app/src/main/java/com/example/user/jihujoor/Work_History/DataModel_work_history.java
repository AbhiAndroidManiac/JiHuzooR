package com.example.user.jihujoor.Work_History;

/**
 * Created by USER on 27-12-2017.
 */

public class DataModel_work_history {

    String cus_name;
    String service;
    String time;
    String rating;


    public DataModel_work_history(String cus_name, String service, String time, String rating) {
        this.cus_name = cus_name;
        this.service = service;
        this.time = time;
        this.rating = rating;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
