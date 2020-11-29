package com.example.livinglab_cultureplatform;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.renderscript.Sampler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;
//import com.google.firebase.database.core.view.View;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Menu1Fragment extends Fragment{

    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu1_home, container, false);

        return view;
    }
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu1_home, container, false);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        viewpager = (ViewPager)view.findViewById(R.id.pager);
        adapter = new ViewPagerAdapter((menu1_home)getActivity(), images);
        viewpager.setAdapter(adapter);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        adapter1 = new ArrayAdapter<String>((menu1_home)getContext(),R.layout.home_list1, data1);
        adapter2 = new ArrayAdapter<String>((menu1_home)getContext(),R.layout.home_list2, data2);
        adapter3 = new ArrayAdapter<String>((menu1_home)getContext(),R.layout.home_list3, data3);
        adapter4 = new ArrayAdapter<String>((menu1_home)getContext(),R.layout.home_list4, data4);


        listview1 = (ListView) view.findViewById(R.id.listV1);
        listview2 = (ListView) view.findViewById(R.id.listV2);
        listview3 = (ListView) view.findViewById(R.id.listV3);
        listview4 = (ListView) view.findViewById(R.id.listV4);

        listview1.setAdapter(adapter1);
        listview2.setAdapter(adapter2);
        listview3.setAdapter(adapter3);
        listview4.setAdapter(adapter4);

        // Obtain the FirebaseAnalytics instance.
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mReference = mDatabase.getReference("gathering");
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String TAG = "파이어베이스 데이터";
                for(DataSnapshot data : snapshot.getChildren()) {
                    //String title = data.getValue(String.class);
                    //String uid = data.getKey().toString();
                    String key = data.getValue().toString();
                    //keydata.add(key);
                    //Log.d("menu1_home", "receive data" + test);

                    String title = data.child(key).child("title").getValue(String.class);
                    data1.add(title);
                    data2.add(title);
                    data3.add(title);
                    data4.add(title);
                }
                adapter1.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();
                adapter3.notifyDataSetChanged();
                adapter4.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }*/

}

        /*
        Button addNfc = view.findViewById(R.id.addNfc);
        Button delNfc = view.findViewById(R.id.delNfc);
        nfcNum = view.findViewById(R.id.nfcNum);
        conSensor = view.findViewById(R.id.conSensor);
        conCam = view.findViewById(R.id.conCam);
        LinearLayout conSensor_extend = view.findViewById(R.id.conSensor_extend);
        LinearLayout conCam_extend = view.findViewById(R.id.conCam_extend);
        addNfc.setOnClickListener(this);
        delNfc.setOnClickListener(this);
        conSensor.setOnClickListener(this);
        conSensor_extend.setOnClickListener(this);
        conCam.setOnClickListener(this);
        conCam_extend.setOnClickListener(this);
        conSensor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mDatabase = FirebaseDatabase.getInstance();
                    mReference = mDatabase.getReference("sensor");
                    mReference.setValue("on");
                    Toast.makeText(getActivity(), "도어센서가 켜졌습니다", Toast.LENGTH_SHORT).show();
                }else{
                    mDatabase = FirebaseDatabase.getInstance();
                    mReference = mDatabase.getReference("sensor");
                    mReference.setValue("off");
                    Toast.makeText(getActivity(), "도어센서가 꺼졌습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        conCam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mDatabase = FirebaseDatabase.getInstance();
                    mReference = mDatabase.getReference("camera");
                    mReference.setValue("on");
                    Toast.makeText(getActivity(), "카메라가 켜졌습니다", Toast.LENGTH_SHORT).show();
                }else{
                    mDatabase = FirebaseDatabase.getInstance();
                    mReference = mDatabase.getReference("camera");
                    mReference.setValue("off");
                    Toast.makeText(getActivity(), "카메라가 꺼졌습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("nfc/Push");
        mReference.addValueEventListener(new ValueEventListener() {
                @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot value : dataSnapshot.getChildren()) {
                        String nfcSerial = value.getValue(String.class);
                        nfcNum.setText(nfcSerial);
                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */
        /*return view;
    }
    public void onClick(View view){
        switch (view.getId()){

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }*/
