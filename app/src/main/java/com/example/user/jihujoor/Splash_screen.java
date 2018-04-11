package com.example.user.jihujoor;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.user.jihujoor.Login.Login_activity;

public class Splash_screen extends Activity {
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity();
                finish();
            }
        },2000);


    }


    public void startActivity(){
        Intent intent = new Intent(Splash_screen.this, Login_activity.class);
        startActivity(intent);
    }

}

