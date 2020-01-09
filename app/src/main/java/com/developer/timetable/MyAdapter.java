package com.developer.timetable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<CardItem> cardItems;
    private Context context;

    public MyAdapter(List<CardItem> cardItems, Context context) {
        this.cardItems = cardItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardItem cardItem = cardItems.get(position);

        holder.tvSubject.setText(cardItem.getSubject());
        holder.tvTeacher.setText(cardItem.getTeacher());
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvSubject, tvTeacher;
        public ViewHolder(View itemView){
            super(itemView);

            tvSubject = itemView.findViewById(R.id.tvCardSubject);
            tvTeacher = itemView.findViewById(R.id.tvCardTeacher);
        }
    }
}
