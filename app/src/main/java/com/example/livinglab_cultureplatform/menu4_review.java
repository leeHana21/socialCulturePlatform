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
import android.widget.ImageView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class menu4_review extends Fragment {
    private RecyclerView reviewRecyclerView;
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    ImageView writeReview;
    ArrayList<review> items = new ArrayList<review>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_menu4_review);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu4_review, container, false);
        FirebaseApp.initializeApp(getActivity());

        writeReview = view.findViewById(R.id.writeReview);

        writeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),review_write.class);
                startActivity(intent);
            }
        });

        reviewRecyclerView = view.findViewById(R.id.reviewRecyclerView);
        reviewRecyclerView.setHasFixedSize(true);
        reviewRecyclerView.addItemDecoration(new RecyclerDecoration(20));
        layoutManager = new LinearLayoutManager(getActivity());

        reviewRecyclerView.setLayoutManager(layoutManager);
        adapter = new reviewAdapter(items);
        reviewRecyclerView.setAdapter(adapter);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("review");

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    String title = postSnapshot.child("title").getValue(String.class);
                    String place = postSnapshot.child("place").getValue(String.class);
                    String pNum = postSnapshot.child("pNum").getValue(String.class);
                    String date = postSnapshot.child("date").getValue(String.class);
                    addReviewItem(title, date, place, pNum);
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
    public void addReviewItem (String title, String date, String place, String pNum){
        review item = new review();
        item.setReTitle(title);
        item.setReDate(date);
        item.setRePlace(place);
        item.setRePNum(pNum);
        items.add(item);
    }
}
