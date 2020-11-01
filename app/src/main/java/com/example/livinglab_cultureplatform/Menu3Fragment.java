package com.example.livinglab_cultureplatform;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Menu3Fragment extends Fragment implements View.OnClickListener {

    FragmentManager manager;
    private Menu2Fragment menu2Fragment = new Menu2Fragment();
    public Menu3Fragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu3_search,container,false);

        return view;


    }

    public void onClick(View view){
        switch (view.getId()){

        }
    }
}