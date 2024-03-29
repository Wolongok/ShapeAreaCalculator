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
import com.example.shapecalculator.adapter.RuangAdapter;
import com.example.shapecalculator.model.BangunModel;

import java.util.ArrayList;


public class RuangFragment extends Fragment implements RuangAdapter.ItemClickListener {

    ArrayList<BangunModel> modelRuang = new ArrayList<>();
    Context context;
    RuangAdapter adapter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context; // Initialize the context here
    }

    public RuangFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        modelRuang.add(new BangunModel("Kubus", "https://drive.google.com/uc?export=download&id=10Ddz_4-ioTbq_Tcr5g_mofxa8LCZtreO"));
        modelRuang.add(new BangunModel("Kerucut", "https://cdn.pixabay.com/photo/2013/07/12/14/13/cone-148003_1280.png"));
        modelRuang.add(new BangunModel("Tabung", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Zylinder-1-tab.svg/232px-Zylinder-1-tab.svg.png"));
        modelRuang.add(new BangunModel("Bola", "https://drive.google.com/uc?export=download&id=1GvJNTZC8sYJj8mkq8skQPNTdhQ_RiNkh"));

        View view = inflater.inflate(R.layout.fragment_ruang, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.RVRuang);



        adapter = new RuangAdapter(context, modelRuang);
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
