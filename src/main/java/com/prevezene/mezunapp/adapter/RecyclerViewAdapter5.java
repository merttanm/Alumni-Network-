package com.prevezene.mezunapp.adapter;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prevezene.mezunapp.R;
import com.prevezene.mezunapp.paper_model;

import java.util.ArrayList;

public class RecyclerViewAdapter5 extends RecyclerView.Adapter<RecyclerViewAdapter5.RowHolder> {
    public ArrayList<paper_model> paperList5;
// renkleri beyaz yaptım
    public String[] colors = {"#F8F7FA","#F8F7FA","#F8F7FA","#F8F7FA","#F8F7FA","#F8F7FA","#F8F7FA","#F8F7FA"};

    public RecyclerViewAdapter5(ArrayList<paper_model> paperList) {
        this.paperList5 = paperList;
    }
    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout5,parent,false);
        return new RowHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(paperList5.get(position),colors,position);
    }
    @Override
    public int getItemCount() {
        return paperList5.size();
    }


    public class RowHolder extends RecyclerView.ViewHolder {
        TextView textName;

        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }



        public void bind(paper_model papermodel,String[] colors, Integer position) {
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]));
            textName = itemView.findViewById(R.id.text_name5);

            textName.setText(papermodel.paper_five);


        }


    }
}