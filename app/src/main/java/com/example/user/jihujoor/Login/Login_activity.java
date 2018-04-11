package com.example.user.jihujoor.Login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.jihujoor.Forgot_Password.Forgot_password;
import com.example.user.jihujoor.R;
import com.example.user.jihujoor.Signup.Vendor_Signup_page;
import com.example.user.jihujoor.Upcoming_shedule.Upcoming_shedule;

public class Login_activity extends AppCompatActivity {

    Button btn_login;
    Button btn_signup;
    EditText editText_email;
    EditText editText_pass;
    TextView textView_forgotpass;
    CheckBox showPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        editText_email=(EditText)findViewById(R.id.email_id);
        editText_pass=(EditText)findViewById(R.id.password);
        btn_login=(Button)findViewById(R.id.login);
        btn_signup=(Button)findViewById(R.id.signup);
        textView_forgotpass=(TextView)findViewById(R.id.forgotpass);
        showPassword=(CheckBox)findViewById(R.id.showPassword);
        Typeface face = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        Typeface face1 = Typeface.createFromAsset(getAssets(), "Quicksand-Bold.otf");
        editText_email.setTypeface(face);
        editText_pass.setTypeface(face);
        btn_login.setTypeface(face);
        btn_signup.setTypeface(face);
        textView_forgotpass.setTypeface(face1);


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_activity.this, Vendor_Signup_page.class));
            }
        });

        textView_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_activity.this, Forgot_password.class));

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_email.getText().toString().trim().equals("guru1@gmail.com")&&editText_pass.getText().toString().equals("123")){
                    startActivity(new Intent(Login_activity.this, Upcoming_shedule.class));
                    Toast.makeText(Login_activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login_activity.this, "enter wrong emil_id or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    Toast.makeText(Login_activity.this, "The show password is not checked", Toast.LENGTH_SHORT).show();
                    editText_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                } else {
                    Toast.makeText(Login_activity.this, "The show password is   checked", Toast.LENGTH_SHORT).show();
                    editText_pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }
            }
        });

    }
}
