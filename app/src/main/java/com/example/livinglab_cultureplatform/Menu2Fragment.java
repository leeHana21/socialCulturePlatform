package com.example.livinglab_cultureplatform;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;

public class Menu2Fragment extends Fragment implements View.OnClickListener{
    Button writeGathering;
    private RecyclerView gatheringRecyclerView;
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu2_gathering, container, false);
        FirebaseApp.initializeApp(getActivity());
        Button daily = view.findViewById(R.id.daily);
        Button leisure = view.findViewById(R.id.leisure);
        Button travel = view.findViewById(R.id.travel);
        Button study = view.findViewById(R.id.study);
        Button free = view.findViewById(R.id.free);
        Button culture = view.findViewById(R.id.culture);

        gatheringRecyclerView = view.findViewById(R.id.gatheringRecyclerView);
        gatheringRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());

//        gatheringRecyclerView.setLayoutManager(layoutManager);
//        adapter = new gatheringAdapter();
//        gatheringRecyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        writeGathering = view.findViewById(R.id.writeGathering);
//        writeGathering.setOnClickListener(this);
        return view;
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.writeGathering:
                Intent intent = new Intent(getActivity(),gatheringWrite.class);
                startActivity(intent);
                break;

        }
        }
    }

