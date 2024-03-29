package com.example.shapecalculator.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.shapecalculator.R;
import com.example.shapecalculator.model.BangunModel;

import java.util.ArrayList;



public class DatarAdapter extends RecyclerView.Adapter<DatarAdapter.MyViewHolder> {
    private ItemClickListener mClickListener;
    Context context;
    ArrayList<BangunModel> modelDatar;

    public DatarAdapter(Context context, ArrayList<BangunModel> modelDatar) {
        this.context = context;
        this.modelDatar = modelDatar;
    }

    @NonNull
    @Override
    public DatarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatarAdapter.MyViewHolder holder, int position) {
        BangunModel currentItem = modelDatar.get(position);
        holder.tvDatar.setText(currentItem.getNama());


        Glide.with(context)
                .load(currentItem.getImg())
                .into(holder.imgDatar);
    }

    @Override
    public int getItemCount() {
        return modelDatar.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDatar;
        TextView tvDatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgDatar = itemView.findViewById(R.id.imgDatar);
            tvDatar = itemView.findViewById(R.id.tvNamaRumus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mClickListener != null) {
                        mClickListener.onItemClick(view, getAdapterPosition());
                    }
                }
            });
        }





    }




    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    
    public BangunModel getItem(int id) {return modelDatar.get(id);}
}
