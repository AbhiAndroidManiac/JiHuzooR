package com.example.user.jihujoor.settings;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ADMIN on 11-04-2018.
 */

public class SharedPreferenceLogin {
    Context context;
    SharedPreferences loginStatus;
    SharedPreferences.Editor loginStatusEditor;
    public SharedPreferenceLogin(Context context) {
        this.context=context;
        loginStatus=context.getSharedPreferences("loginFlag",Context.MODE_PRIVATE);
        loginStatusEditor=loginStatus.edit();
    }
    public void saveLoginStatus(boolean loginFlag){
        loginStatusEditor.putBoolean("loginFlag",loginFlag).commit();
    }
    public boolean getLoginStatus(){
        return loginStatus.getBoolean("loginFlag",false);
    }

}
