package com.example.user.jihujoor.Work_History;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.user.jihujoor.R;

public class Work_history extends AppCompatActivity {

    ListView listView;
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_history);

        listView = (ListView)findViewById(R.id.list);
        img_back=(ImageView)findViewById(R.id.back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBack();
            }
        });

        DataModel_work_history[] dataModel_work_history = new DataModel_work_history[]{

                new DataModel_work_history("pawan kumar","plumber","10am","4/5"),
                new DataModel_work_history("pawan kumar","plumber","10am","4/5"),
                new DataModel_work_history("pawan kumar","plumber","10am","4/5"),
                new DataModel_work_history("pawan kumar","plumber","10am","4/5"),
                new DataModel_work_history("pawan kumar","plumber","10am","4/5"),
                new DataModel_work_history("pawan kumar","plumber","10am","4/5"),
        };

        Adapter_Work_History adapter_work_history = new Adapter_Work_History(getApplicationContext(),R.layout.list_item_work_hisory,dataModel_work_history);
        listView.setAdapter(adapter_work_history);

    }

    public void onBack(){
        super.onBackPressed();
    }
}
