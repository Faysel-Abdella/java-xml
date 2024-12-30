package com.example.carwash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class LevelGridAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;

    public LevelGridAdapter(Context context, List<CustomerLevel> customerLevelList) {
        this.context = context;
        this.customerLevelList = customerLevelList;
    }

    Context context;
    List<CustomerLevel> customerLevelList;

    @Override
    public int getCount() {
        return customerLevelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
//        if (convertView == null) {
//            convertView = layoutInflater.inflate(R.layout.level_show, null);
//        }


        return convertView;
    }
}
