package com.example.appthoitiet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appthoitiet.ConvertJson.convert;
import com.example.appthoitiet.DBManage.DBsetting;
import com.example.appthoitiet.R;
import com.example.appthoitiet.Model.history;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<history> {

    DBsetting dBsetting = new DBsetting(getContext());
    private Context context;
    private ArrayList<history> histories;
    private int resource;
    private convert convert= new convert();

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<history> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.histories = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_lisview, parent, false);
        TextView Tvtimehistory = convertView.findViewById(R.id.Tvtimehistory);
        TextView Tvhistoryname = convertView.findViewById(R.id.Tvhistoryname);
        TextView Tvhistorynhietdo = convertView.findViewById(R.id.Tvhistorynhietdo);
        ImageView Imvicon = convertView.findViewById(R.id.Imicon);
        TextView Tvtrangthaitt = convertView.findViewById(R.id.Tvtrangthaitt);
        TextView Tvdayandmonth = convertView.findViewById(R.id.Tvdayandmonth);
        TextView tvccc = convertView.findViewById(R.id.Tvccc);
        history history123 = histories.get(position);
        String a = history123.getIcon().toString();
        int b = 0;
       b= convert.convertweather(a,b);
        Imvicon.setImageResource(b);

        Tvhistoryname.setText(history123.getName());

        if (dBsetting.getAllSetting().get(0).getNhietdost() == 1) {
            Tvhistorynhietdo.setText((int) (history123.getTemperature() * 1.8 + 32) + "");
            tvccc.setText("F");

        } else
            Tvhistorynhietdo.setText(history123.getTemperature() + "");
        Tvtimehistory.setText(history123.getTime());
        Tvdayandmonth.setText(history123.getDayandmonth());
        Tvtrangthaitt.setText(history123.getTrangthaitt());


        return convertView;
    }
}
