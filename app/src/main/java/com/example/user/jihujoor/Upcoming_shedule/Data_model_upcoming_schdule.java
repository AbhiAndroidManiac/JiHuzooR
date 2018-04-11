package com.example.user.jihujoor.Upcoming_shedule;

/**
 * Created by USER on 27-12-2017.
 */

public class Data_model_upcoming_schdule {

    String customer_name;
    String place;
    String service_need;
    String time;
    String set_price;
    String status;

    public Data_model_upcoming_schdule(String customer_name, String place, String service_need, String time, String set_price, String status) {
        this.customer_name = customer_name;
        this.place = place;
        this.service_need = service_need;
        this.time = time;
        this.set_price = set_price;
        this.status = status;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getService_need() {
        return service_need;
    }

    public void setService_need(String service_need) {
        this.service_need = service_need;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSet_price() {
        return set_price;
    }

    public void setSet_price(String set_price) {
        this.set_price = set_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
