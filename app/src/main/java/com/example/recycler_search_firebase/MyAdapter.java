package com.example.recycler_search_firebase;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Deal> list;
    public MyAdapter(ArrayList<Deal> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.proname.setText(list.get(position).getPro_name());
        holder.prodec.setText(list.get(position).getPro_desc());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView proname,prodec;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            proname = itemView.findViewById(R.id.detailid);
            prodec  = itemView.findViewById(R.id.description);

        }
    }

   }
