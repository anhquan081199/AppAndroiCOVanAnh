package com.example.appthoitiet.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.appthoitiet.Model.Contect;

import com.example.appthoitiet.R;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHoder> {
    private List<Contect> Contacts;


    public AdapterContact(List<Contect> Contacts) {
        this.Contacts = Contacts;
    }



    @NonNull
    @Override
    public AdapterContact.ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.ViewHoder holder, int position) {
        Contect contect = Contacts.get(position);

        if (contect.getTvcf() == 1) {
            holder.Tvcitem.setText("F");
        }

        holder.doam.setText(contect.getDoam() + "%");
        holder.wheather.setImageResource(contect.getIcon());
        holder.nhietdo.setText(contect.getNhietdo() + "");
        holder.time.setText(contect.getTime() + "");
    }

    @Override
    public int getItemCount() {
        return Contacts.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView time, nhietdo, doam, Tvcitem;
        ImageView wheather;

        public ViewHoder(@NonNull View itemView) {

            super(itemView);
            doam = itemView.findViewById(R.id.doam);
            time = itemView.findViewById(R.id.timeofday);
            nhietdo = itemView.findViewById(R.id.nhietdo);
            wheather = itemView.findViewById(R.id.weather);
            Tvcitem = itemView.findViewById(R.id.TvCitem);
        }
    }
}
