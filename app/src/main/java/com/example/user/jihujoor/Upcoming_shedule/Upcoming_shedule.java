package com.example.user.jihujoor.Upcoming_shedule;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.jihujoor.gps_tracking.Gps_tracker;
import com.example.user.jihujoor.Home_Page.Home;
import com.example.user.jihujoor.R;
import com.example.user.jihujoor.User_Profile.Profile;
import com.example.user.jihujoor.Work_History.Work_history;
import com.example.user.jihujoor.sharedPreferenceAsset.SettingPreferenceLatLong;

import java.util.ArrayList;
import java.util.List;

public class Upcoming_shedule extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    List<Data_model_upcoming_schdule> list;
    Gps_tracker gps_tracker ;
    Intent intent;
    double latitude;
    double longitude;
    String resultResponse;
    SettingPreferenceLatLong settingPreferenceLatLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_shedule);
        settingPreferenceLatLong=new SettingPreferenceLatLong(Upcoming_shedule.this);

        listView = (ListView) findViewById(R.id.list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /**gps_tracker = new Gps_tracker(this);

        if(gps_tracker.canGetLocation()){

            latitude=gps_tracker.getLatitude();
            longitude=gps_tracker.getLongitude();
        }
        else {
            gps_tracker.showSettingsAlert();
        }**/

        Data_model_upcoming_schdule[] data_model_upcoming_schdule = new Data_model_upcoming_schdule[]{

                new Data_model_upcoming_schdule("pawan kumar","kolkata","plumber","10.30","500","hold"),
                new Data_model_upcoming_schdule("pawan kumar","kolkata","plumber","10.30","500","hold"),
                new Data_model_upcoming_schdule("pawan kumar","kolkata","plumber","10.30","500","hold"),
                new Data_model_upcoming_schdule("pawan kumar","kolkata","plumber","10.30","500","hold"),
                new Data_model_upcoming_schdule("pawan kumar","kolkata","plumber","10.30","500","hold"),
                new Data_model_upcoming_schdule("pawan kumar","kolkata","plumber","10.30","500","hold"),
        };

        Adapter_upcomingSchdule adapter_upcomingSchdule = new Adapter_upcomingSchdule(getApplicationContext(),R.layout.card_layout,data_model_upcoming_schdule);
        listView.setAdapter(adapter_upcomingSchdule);


    }



    public void backButton(){
        super.onBackPressed();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AsyncTaskRunner runner = new AsyncTaskRunner();
            runner.execute();
            Toast.makeText(getApplicationContext(),
                    "The latitude of the item is And the longitude of the item is"+settingPreferenceLatLong.getPayuResponse(),
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(getApplicationContext(), "The onclick working of the side button", Toast.LENGTH_SHORT).show();
            // Handle the camera action

        } else if (id == R.id.upcoming_shedule) {
            startActivity(new Intent(Upcoming_shedule.this, Upcoming_shedule.class));

        }
        else if(id==R.id.work_history){
            startActivity(new Intent(Upcoming_shedule.this, Work_history.class));
        }
        else if (id == R.id.nav_profile) {
            startActivity(new Intent(Upcoming_shedule.this, Profile.class));
        } else if (id == R.id.nav_logout) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(intent);

    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            Gps_tracker gps = new Gps_tracker(getApplicationContext());
            // check if GPS location can get Location
            if (gps.canGetLocation()) {
                LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

                if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    Log.d("Your Location", "latitude:" + gps.getLatitude()
                            + ", longitude: " + gps.getLongitude());

                    double lon = gps.getLongitude();
                    double lat = gps.getLatitude();

                    resultResponse=String.valueOf(lon+"THe string value of the long and lat"+lat);
                }
            }else {
                gps.showSettingsAlert();
                resultResponse=null;
            }
            return resultResponse;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
                settingPreferenceLatLong.savePayuResponse(s);
        }
    }
}
