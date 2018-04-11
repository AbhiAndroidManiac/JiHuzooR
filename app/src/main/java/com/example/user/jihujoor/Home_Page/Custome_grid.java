package com.example.user.jihujoor.Home_Page;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.jihujoor.R;

import java.util.ArrayList;

/**
 * Created by USER on 26-12-2017.
 */

public class Custome_grid extends BaseAdapter implements Filterable {
    Context mContext;
    ArrayList<Data_model> dataset;
    ArrayList<Data_model> dataFilter;
    Customefilter filter;

    public Custome_grid(Context mContext, ArrayList<Data_model> dataset) {
        this.mContext = mContext;
        this.dataset=dataset;
        this.dataFilter=dataset;
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataset.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
        } else {
            grid =  convertView;
        }
        TextView textView = (TextView) grid.findViewById(R.id.grid_text);
        ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
        Typeface face = Typeface.createFromAsset(mContext.getAssets(), "Quicksand-Bold.otf");
        textView.setTypeface(face);
        textView.setText(dataset.get(position).getName());
        imageView.setImageResource(dataset.get(position).getImg());

        return grid;

    }

    @Override
    public Filter getFilter() {

        if(filter==null){
            filter=new Customefilter();
        }
        return filter;
    }

    class Customefilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults filterResults = new FilterResults();

            if(constraint!=null&&constraint.length()>0){
                constraint = constraint.toString().toUpperCase();
                ArrayList<Data_model> filters = new ArrayList<>();

                for(int i=0;i<dataFilter.size();i++){

                    if(dataFilter.get(i).getName().toUpperCase().contains(constraint)){

                        Data_model data_model = new Data_model(dataFilter.get(i).getName(),dataFilter.get(i).getImg());
                        filters.add(data_model);
                    }
                }

                filterResults.count=filters.size();
                filterResults.values=filters;
            }else{

                filterResults.count=dataFilter.size();
                filterResults.values=dataFilter;
            }


            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

             dataset=(ArrayList<Data_model>)results.values;
            notifyDataSetChanged();
        }
    }
}
