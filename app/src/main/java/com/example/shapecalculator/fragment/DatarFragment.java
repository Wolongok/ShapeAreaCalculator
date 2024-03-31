package com.example.shapecalculator.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shapecalculator.R;
import com.example.shapecalculator.RumusPage;
import com.example.shapecalculator.adapter.DatarAdapter;
import com.example.shapecalculator.model.BangunModel;

import java.util.ArrayList;


public class DatarFragment extends Fragment implements DatarAdapter.ItemClickListener{

    ArrayList<BangunModel> modelDatar = new ArrayList<>();
    Context context;
    DatarAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context; // Initialize the context here
    }
    public DatarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        modelDatar.add(new BangunModel("Persegi", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Regular_quadrilateral.svg/250px-Regular_quadrilateral.svg.png"));
        modelDatar.add(new BangunModel("Lingkaran", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Circle-withsegments.svg/768px-Circle-withsegments.svg.png"));
        modelDatar.add(new BangunModel("Segitiga", "https://drive.usercontent.google.com/u/0/uc?id=12cLjr_YUjgBYI8i9AyefvffSZaegy5LP&export=download"));
        modelDatar.add(new BangunModel("Persegi Panjang", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Rectangle_Geometry_Vector.svg/330px-Rectangle_Geometry_Vector.svg.png"));

        View view = inflater.inflate(R.layout.fragment_datar, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.RVDatar);



        adapter = new DatarAdapter(context, modelDatar);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {


        Intent intent = new Intent(requireContext(), RumusPage.class);
        intent.putExtra("nama",adapter.getItem(position).getNama());
        startActivity(intent);

        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position).getNama() + " on row number " + (position + 1), Toast.LENGTH_SHORT).show();
    }



}

