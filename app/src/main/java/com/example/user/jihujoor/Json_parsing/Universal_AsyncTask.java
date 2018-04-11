package com.example.user.jihujoor.Json_parsing;

import android.os.AsyncTask;

/**
 * Created by dcp on 25-07-2017.
 */

public class Universal_AsyncTask extends AsyncTask<String, Void, String> {
    private AsyncsCallback async;
    String param="";

    public Universal_AsyncTask(AsyncsCallback async, String param) {
        this.async = async;
        this.param = param;
    }

    @Override
    protected void onPreExecute() {
       if (async!=null){
           async.onstart();
       }
    }

    @Override
    protected void onPostExecute(String s) {
        if (async!=null){
            async.onFinish(s);
        }


    }

    @Override
    protected String doInBackground(String... params) {
        return  JSONParser.makeHttpRequest(
                    params[0], "POST", param);

    }


}
