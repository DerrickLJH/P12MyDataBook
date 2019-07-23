package com.myapplicationdev.android.p12_mydatabook;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {
    private String[] nav;
    private Context context;
    private TextView tvTitle;
    private ImageView ivIcon;

    public MyAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        nav = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_row, parent, false);

        tvTitle = rowView.findViewById(R.id.tvTitle);
        ivIcon = rowView.findViewById(R.id.ivIcon);

        String currentNav = nav[position];
        tvTitle.setText(currentNav);

        if (currentNav.equals("Bio")){
            ivIcon.setImageResource(R.drawable.ic_info_black_24dp);
        } else if (currentNav.equals("Vaccination")){
            ivIcon.setImageResource(R.drawable.ic_create_black_24dp);
        } else if (currentNav.equals("Anniversary")){
            ivIcon.setImageResource(R.drawable.ic_today_black_24dp);
        } else {
            ivIcon.setImageResource(R.drawable.ic_star_black_24dp);
        }
        return rowView;
    }
}
