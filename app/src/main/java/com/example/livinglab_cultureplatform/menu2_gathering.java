package com.example.livinglab_cultureplatform;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Observer;

public class menu2_gathering extends Fragment  {
    private RecyclerView gatheringRecyclerView;
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    ArrayList<gathering> items = new ArrayList<gathering>();
    Button daily, leisure, travel, study, free, culture, writeGathering;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu2_gathering);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu2_gathering, container, false);
        FirebaseApp.initializeApp(getActivity());
        daily = view.findViewById(R.id.daily);
        leisure = view.findViewById(R.id.leisure);
        travel = view.findViewById(R.id.travel);
        study = view.findViewById(R.id.study);
        free = view.findViewById(R.id.free);
        culture = view.findViewById(R.id.culture);
        writeGathering = view.findViewById(R.id.writeGathering);

        writeGathering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),gatheringWrite.class);
                startActivity(intent);
            }
        });

        gatheringRecyclerView = view.findViewById(R.id.gatheringRecyclerView);
        gatheringRecyclerView.setHasFixedSize(true);
        gatheringRecyclerView.addItemDecoration(new RecyclerDecoration(5));
        layoutManager = new LinearLayoutManager(getActivity());

        gatheringRecyclerView.setLayoutManager(layoutManager);
        adapter = new gatheringAdapter(items);
        gatheringRecyclerView.setAdapter(adapter);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("gathering");

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                String title = postSnapshot.child("title").getValue(String.class);
                String place = postSnapshot.child("place").getValue(String.class);
                String pNum = postSnapshot.child("peopleNum").getValue(String.class);
                String price = postSnapshot.child("price").getValue(String.class);
                String date = postSnapshot.child("date").getValue(String.class);
                addItem(title, date, place, price, pNum);
                }
                adapter.notifyDataSetChanged();
                //holder.notify();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter.notifyDataSetChanged();
        return view;
    };
    public void addItem (String title, String date, String place, String price, String pNum){
        gathering item = new gathering();
        item.setTitle(title);
        item.setDate(date);
        item.setPlace(place);
        item.setPrice(price);
        item.setpNum(pNum);
        items.add(item);
    }
}
