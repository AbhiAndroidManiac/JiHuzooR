package com.example.user.jihujoor.Forgot_Password;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.jihujoor.Login.Login_activity;
import com.example.user.jihujoor.R;

public class Forgot_password extends AppCompatActivity {

    TextView textView_back_to_login;
    EditText forgot_e_email;
    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        textView_back_to_login=(TextView)findViewById(R.id.backtologin);
        forgot_e_email=(EditText)findViewById(R.id.email_id);
        btn_submit=(Button)findViewById(R.id.submit);

        textView_back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forgot_password.this, Login_activity.class));
            }
        });
    }
}
