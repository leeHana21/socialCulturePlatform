package com.example.livinglab_cultureplatform;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
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


public class menu1_home extends Fragment {
    private ViewPager viewpager;
    private ViewPagerAdapter adapter;

    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private ArrayAdapter<String> adapter4;
    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();
    private ArrayList<String> data4 = new ArrayList<String>();
    private ArrayList<String> keydata = new ArrayList<String>();
    private ListView listview1;
    private ListView listview2;
    private ListView listview3;
    private ListView listview4;

    private DatabaseReference mDatabase;

    int[] images = {R.drawable.banner_main, R.drawable.banner2, R.drawable.banner3};
    CircleIndicator indicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu1_home);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu1_home, container, false);

        viewpager = (ViewPager)view.findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(this.getContext(), images);
        viewpager.setAdapter(adapter);
        indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(viewpager);

        //viewpager.setClipToPadding(false);
        /*if(!FirebaseApp.getApps(this.getContext()).isEmpty()) {
            FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }*/

        adapter1 = new ArrayAdapter<String>(this.getContext(),R.layout.home_list1, R.id.textView, data1);
        adapter2 = new ArrayAdapter<String>(this.getContext(),R.layout.home_list2, R.id.textView2, data2);
        adapter3 = new ArrayAdapter<String>(this.getContext(),R.layout.home_list3, R.id.textView3, data3);
        adapter4 = new ArrayAdapter<String>(this.getContext(),R.layout.home_list4, R.id.textView4, data4);


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
        DatabaseReference mReference = mDatabase.getReference();
        mReference.child("gathering").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String TAG = "파이어베이스 데이터";
                for(DataSnapshot data : snapshot.getChildren()) {
                    //String title = data.getValue(String.class);
                    //String uid = data.getKey().toString();

                    //Object key = data.getValue();

                    //keydata.add(key);
                    //Log.d("menu1_home", "receive data" + test);

                    //String title = data.child(ObjToString(key)).child("title").getValue(String.class);
                    String title = data.child("title").getValue(String.class);
                    data1.add(title);
                }
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mReference.child("review").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String TAG = "파이어베이스 데이터";
                for(DataSnapshot data : snapshot.getChildren()) {
                    //String title = data.getValue(String.class);
                    //String uid = data.getKey().toString();

                    //Object key = data.getValue();

                    //keydata.add(key);
                    //Log.d("menu1_home", "receive data" + test);

                    //String title = data.child(ObjToString(key)).child("title").getValue(String.class);
                    String title = data.child("title").getValue(String.class);
                    data3.add(title);
                }
                adapter3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mReference.child("local").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String TAG = "파이어베이스 데이터";
                for(DataSnapshot data : snapshot.getChildren()) {
                    //String title = data.getValue(String.class);
                    //String uid = data.getKey().toString();

                    //Object key = data.getValue();

                    //keydata.add(key);
                    //Log.d("menu1_home", "receive data" + test);

                    //String title = data.child(ObjToString(key)).child("title").getValue(String.class);
                    String title = data.getValue(String.class);
                    data2.add(title);

                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mReference.child("communicate").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String TAG = "파이어베이스 데이터";
                for(DataSnapshot data : snapshot.getChildren()) {
                    //String title = data.getValue(String.class);
                    //String uid = data.getKey().toString();

                    //Object key = data.getValue();

                    //keydata.add(key);
                    //Log.d("menu1_home", "receive data" + test);

                    //String title = data.child(ObjToString(key)).child("title").getValue(String.class);
                    String title = data.getValue(String.class);
                    data4.add(title);
                }
                adapter4.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }

    private String ObjToString(Object key){

        return key == null ? "" : key.toString();
    }
}
