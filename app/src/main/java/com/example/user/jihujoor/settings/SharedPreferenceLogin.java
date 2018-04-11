package com.example.user.jihujoor.settings;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ADMIN on 11-04-2018.
 */

public class SharedPreferenceLogin {
    Context context;
    SharedPreferences loginStatus,accessToken;
    SharedPreferences.Editor loginStatusEditor,accessTokenEditor;

    public SharedPreferenceLogin() {
    }

    public SharedPreferenceLogin(Context context) {
        this.context=context;
        loginStatus=context.getSharedPreferences("loginFlag",Context.MODE_PRIVATE);
        loginStatusEditor=loginStatus.edit();
        accessToken=context.getSharedPreferences("accessToken",Context.MODE_PRIVATE);
        accessTokenEditor=accessToken.edit();
    }
    public void saveLoginStatus(boolean loginFlag){
        loginStatusEditor.putBoolean("loginFlag",loginFlag).commit();
    }
    public boolean getLoginStatus(){
        return loginStatus.getBoolean("loginFlag",false);
    }
    public void saveAccessToken(String accessToken){
        accessTokenEditor.putString("accessToken",accessToken);
    }
    public String getAccessToken(){
        return accessToken.getString("accessToken",null);
    }

}
