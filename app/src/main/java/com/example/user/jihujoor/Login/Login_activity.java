package com.example.user.jihujoor.Login;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.user.jihujoor.Forgot_Password.Forgot_password;
import com.example.user.jihujoor.R;
import com.example.user.jihujoor.Signup.Vendor_Signup_page;
import com.example.user.jihujoor.Upcoming_shedule.Upcoming_shedule;
import com.example.user.jihujoor.app.AppConfig;
import com.example.user.jihujoor.app.AppController;
import com.example.user.jihujoor.settings.SharedPreferenceLogin;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login_activity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;
    Button btn_signup;
    EditText editText_email;
    EditText editText_pass;
    TextView textView_forgotpass;
    CheckBox showPassword;
    String deviceId;
    TelephonyManager telephonyManager;
    ProgressDialog pDialog;
    SharedPreferenceLogin sharedPreferenceLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        editText_email = (EditText) findViewById(R.id.email_id);
        editText_pass = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.login);
        btn_signup = (Button) findViewById(R.id.signup);
        textView_forgotpass = (TextView) findViewById(R.id.forgotpass);
        showPassword = (CheckBox) findViewById(R.id.showPassword);
        Typeface face = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        Typeface face1 = Typeface.createFromAsset(getAssets(), "Quicksand-Bold.otf");
        editText_email.setTypeface(face);
        editText_pass.setTypeface(face);
        btn_login.setTypeface(face);
        btn_signup.setTypeface(face);
        textView_forgotpass.setTypeface(face1);
        pDialog=new ProgressDialog(this);
        pDialog.setCancelable(false);
        sharedPreferenceLogin=new SharedPreferenceLogin(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
         telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        deviceId=telephonyManager.getDeviceId();


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

        btn_login.setOnClickListener((View.OnClickListener) this);

        /**{
            @Override
            public void onClick(View v) {
                if (editText_email.getText().toString().trim().equals("guru1@gmail.com") && editText_pass.getText().toString().equals("123")) {
                    startActivity(new Intent(Login_activity.this, Upcoming_shedule.class));
                    if (ActivityCompat.checkSelfPermission(Login_activity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Toast.makeText(Login_activity.this, telephonyManager.getDeviceId(), Toast.LENGTH_SHORT).show();
                    Log.e("deviceID",telephonyManager.getDeviceId());
                    Toast.makeText(Login_activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login_activity.this, "enter wrong emil_id or password", Toast.LENGTH_SHORT).show();
                }
            }
        });**/
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

    @Override
    public void onClick(View v) {
        String vendorEmail, vendorPassword;
        vendorEmail=editText_email.getText().toString().trim();
        vendorPassword=editText_pass.getText().toString().trim();

        if (v.getId()==R.id.login){
            if (vendorEmail.isEmpty()){
                Toast.makeText(this, "Please enter email address of user", Toast.LENGTH_SHORT).show();
            }
            if (vendorPassword.isEmpty()){
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            }

            loginExecution(vendorEmail,vendorPassword);
            Toast.makeText(this, "THe button click working", Toast.LENGTH_SHORT).show();

        }

    }

    public void loginExecution(final String vendorEmail, final String vendorPassword){
        pDialog.setMessage("Login In...Please Wait...");
        showDialog();

        //String loginUrl="http://192.168.0.11:8084/jihuzur/vendorlogin";
        Map<String, String> params = new HashMap<String, String>();
        params.put("choose", "Individual");
        params.put("password", vendorPassword);
        params.put("username", vendorEmail);
        params.put("callFrom", "Mobile");
        params.put("imei", deviceId);


        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, AppConfig.Base_URL_JIHUZOOR, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                hideDialog();
                JSONObject jsonObject=null;
                try {
                    jsonObject=new JSONObject(String.valueOf(response));
                    if (jsonObject.getString("isapproved").equalsIgnoreCase("true")){
                        AppConfig.access_token=jsonObject.getString("accessToken");
                        sharedPreferenceLogin.saveAccessToken(AppConfig.access_token);
                        Toast.makeText(getApplicationContext(), AppConfig.access_token, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(
                                Login_activity.this,
                                Upcoming_shedule.class);
                        startActivity(intent);
                        finish();

                        Toast.makeText(getApplicationContext(), "The result of the json retrieval"+jsonObject.getString("isapproved") , Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "There is some error", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(getApplicationContext(), "THe error is"+error, Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

        }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    }

