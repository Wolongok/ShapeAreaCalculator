package com.example.shapecalculator.adapter;

import android.content.Context;
import android.util.Log;
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

public class RuangAdapter extends RecyclerView.Adapter<RuangAdapter.MyViewHolder> {

    private ItemClickListener mClickListener;
    Context context;
    ArrayList<BangunModel> modelRuang;

    public RuangAdapter(Context context, ArrayList<BangunModel> modelDatar) {
        this.context = context;
        this.modelRuang = modelDatar;
    }

    @NonNull
    @Override
    public RuangAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RuangAdapter.MyViewHolder holder, int position) {
        BangunModel currentItem = modelRuang.get(position);
        holder.tvRuang.setText(currentItem.getNama());


        Glide.with(context)
                .load(currentItem.getImg())
                .into(holder.imgRuang);
    }

    @Override
    public int getItemCount() {
        return modelRuang.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRuang;
        TextView tvRuang;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            imgRuang = itemView.findViewById(R.id.imgDatar);
            tvRuang = itemView.findViewById(R.id.tvNamaRumus);

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


    public void setClickListener(RuangAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public BangunModel getItem(int id) {return modelRuang.get(id);}
}
