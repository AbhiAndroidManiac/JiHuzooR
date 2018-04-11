package com.example.user.jihujoor.Home_Page;

/**
 * Created by USER on 27-12-2017.
 */

public class Data_model {
    String name;
    int img;

    public Data_model(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
