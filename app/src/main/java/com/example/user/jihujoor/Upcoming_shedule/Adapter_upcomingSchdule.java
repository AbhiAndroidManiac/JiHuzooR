package com.example.user.jihujoor.Upcoming_shedule;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.jihujoor.R;


/**
 * Created by dcp on 16-06-2017.
 */

public class Adapter_upcomingSchdule extends ArrayAdapter<Data_model_upcoming_schdule> {

    Context context;
    int ResourceId;
    Data_model_upcoming_schdule []data = null;

    public Adapter_upcomingSchdule(Context context, int resource, Data_model_upcoming_schdule []data) {
        super(context, resource,data);
        this.context=context;
        this.ResourceId=resource;
        this.data=data;
    }

    public View getView(final int Position, View ConvertView, ViewGroup Parent){
        Dataholder holder = null;
       final Data_model_upcoming_schdule rowItem = getItem(Position);

        if(ConvertView==null){
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            ConvertView = mInflater.inflate(R.layout.card_layout, null);
            holder = new Dataholder();
            holder.cutomer_name=(TextView)ConvertView.findViewById(R.id.customer_name);
            holder.place=(TextView)ConvertView.findViewById(R.id.place);
            holder.service_need=(TextView)ConvertView.findViewById(R.id.service_need);
            holder.time=(TextView)ConvertView.findViewById(R.id.time);
            holder.set_price=(TextView)ConvertView.findViewById(R.id.set_price);
            holder.status=(TextView)ConvertView.findViewById(R.id.text_hold);


            ConvertView.setTag(holder);
        }else {
            holder = (Dataholder) ConvertView.getTag();
        }
        holder.cutomer_name.setText(rowItem.getCustomer_name());
        holder.place.setText(rowItem.getPlace());
        holder.service_need.setText(rowItem.getService_need());
        holder.time.setText(rowItem.getTime());
        holder.set_price.setText(rowItem.getSet_price());
        holder.status.setText(rowItem.getStatus());

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
        public TextView place;
        public TextView service_need;
        public TextView time;
        public TextView set_price;
        public TextView status;
    }
}
