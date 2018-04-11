package com.example.user.jihujoor.Home_Page;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.user.jihujoor.R;
import com.example.user.jihujoor.Upcoming_shedule.Upcoming_shedule;
import com.example.user.jihujoor.User_Profile.Profile;
import com.example.user.jihujoor.Work_History.Work_history;

import java.util.ArrayList;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[] name = {"Florists",
                        "Lawyers",
                        "Guitar Instructor",
                        "Maid Services",
                        "Packers and Movers",
                        "Painter",
                        "Pest Control",
                        "Photographer",
                        "Physiotherapist",
                        "Plumber",
                        "Priest Services",
                        "Repairing",
                        "Transportation",
                        "Yoga",
                        "Web Designer",
                        "Software Developer",
                        };
    int[] img = {R.drawable._florist,
            R.drawable._lawyer,
            R.drawable.guitar_instructor,
            R.drawable.maid_services,
            R.drawable.packers_and_movers,
            R.drawable.painter,
            R.drawable.pest_control,
            R.drawable.photographer,
            R.drawable.physiotherapist,
            R.drawable.plumber,
            R.drawable.priestservices ,
            R.drawable.repairing,
            R.drawable.transportation,
            R.drawable.yyoga,
            R.drawable.webdesginer,
            R.drawable.softwaredeveloper,
           };
    GridView gridView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView=(GridView)findViewById(R.id.grid);
        searchView=(SearchView)findViewById(R.id.search);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final Custome_grid custome_grid = new Custome_grid(getApplicationContext(),this.getsearch());
        gridView.setAdapter(custome_grid);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                custome_grid.getFilter().filter(newText);
                return false;
            }
        });

    }
    public ArrayList<Data_model> getsearch(){

        ArrayList<Data_model> list = new ArrayList<>();
        Data_model data_model;
        for(int i=0;i<name.length;i++){
            data_model = new Data_model(name[i],img[i]);
            list.add(data_model);
        }
        return list;
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
            // Handle the camera action
        } else if (id == R.id.upcoming_shedule) {
            startActivity(new Intent(Home.this, Upcoming_shedule.class));

        }
        else if(id==R.id.work_history){
            startActivity(new Intent(Home.this, Work_history.class));
        }
        else if (id == R.id.nav_profile) {
            startActivity(new Intent(Home.this, Profile.class));
        } else if (id == R.id.nav_logout) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
