package com.example.user.jihujoor.Work_History;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.jihujoor.R;
import com.example.user.jihujoor.Upcoming_shedule.Data_model_upcoming_schdule;


/**
 * Created by dcp on 16-06-2017.
 */

public class Adapter_Work_History extends ArrayAdapter<DataModel_work_history> {

    Context context;
    int ResourceId;
    DataModel_work_history []data = null;

    public Adapter_Work_History(Context context, int resource, DataModel_work_history []data) {
        super(context, resource,data);
        this.context=context;
        this.ResourceId=resource;
        this.data=data;
    }

    public View getView(final int Position, View ConvertView, ViewGroup Parent){
        Dataholder holder = null;
       final DataModel_work_history rowItem = getItem(Position);

        if(ConvertView==null){
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            ConvertView = mInflater.inflate(R.layout.list_item_work_hisory, null);
            holder = new Dataholder();
            holder.cutomer_name=(TextView)ConvertView.findViewById(R.id.customer_name);
            holder.service=(TextView)ConvertView.findViewById(R.id.service_need);
            holder.time=(TextView)ConvertView.findViewById(R.id.time);
            holder.rating=(TextView)ConvertView.findViewById(R.id.rating);


            ConvertView.setTag(holder);
        }else {
            holder = (Dataholder) ConvertView.getTag();
        }
        holder.cutomer_name.setText(rowItem.getCus_name());
        holder.service.setText(rowItem.getService());
        holder.time.setText(rowItem.getTime());
        holder.rating.setText(rowItem.getRating());

        /*
        ConvertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+rowItem.getId(), Toast.LENGTH_SHORT).show();
                ((Place_toVisit)context).goto_activity(Position);

            }
        });
*/

        return ConvertView;
    }

    private class Dataholder {
        public TextView cutomer_name;
        public TextView service;
        public TextView time;
        public TextView rating;
    }
}
