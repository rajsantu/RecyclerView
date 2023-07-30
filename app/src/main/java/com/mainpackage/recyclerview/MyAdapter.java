package com.mainpackage.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class MyAdapter extends Adapter<MyAdapter.MyViewHolder> {

    // 1- Data Source
    private final VaccineModel[] listData;
    // 4- Handling the Click Events
    public ItemClickListener clickListener;

    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // 3- Implementing the Methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(listItem);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final VaccineModel myListData = listData[position];
        holder.textView.setText(myListData.getTitle());
        holder.imageView.setImageResource(myListData.getImage());


    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    // 2- View Holder Class:
    public class MyViewHolder extends ViewHolder implements
            View.OnClickListener {
        public ImageView imageView;
        public TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {

                clickListener.onClick(view, getAbsoluteAdapterPosition());
            }

        }
    }

}
