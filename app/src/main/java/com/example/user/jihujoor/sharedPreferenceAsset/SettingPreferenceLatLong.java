package com.example.user.jihujoor.sharedPreferenceAsset;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ADMIN on 09-04-2018.
 */



public class SettingPreferenceLatLong {
    Context context;
    SharedPreferences latandlong;
    SharedPreferences.Editor latandlongEditor;

    public SettingPreferenceLatLong(Context context) {
        this.context=context;
        latandlong=context.getSharedPreferences("latandlong",Context.MODE_PRIVATE);
        latandlongEditor=latandlong.edit();
    }

    public void savePayuResponse(String subscriptionMapId){
        latandlongEditor.putString("latandlong",subscriptionMapId).commit();
    }

    public String getPayuResponse(){
        return latandlong.getString("latandlong",null);
    }
}