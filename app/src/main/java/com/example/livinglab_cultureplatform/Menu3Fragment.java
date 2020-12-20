package com.example.livinglab_cultureplatform;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Menu3Fragment extends Fragment implements View.OnClickListener {
    Button searchBtn;
    TextView test, searchResult;
    EditText searchEdit;
    FragmentManager manager;
    private Menu2Fragment menu2Fragment = new Menu2Fragment();
    public Menu3Fragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu3_search,container,false);
        searchBtn = view.findViewById(R.id.searchBtn);
        searchResult = view.findViewById(R.id.searchResult);
        test = view.findViewById(R.id.test);
        searchEdit = view.findViewById(R.id.searchEdit);
        searchBtn.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.searchBtn:
                String text = searchEdit.getText().toString();
                if(text.equals("가평")){
                    searchResult.setText("총 1개의 결과를 찾았습니다");
                    test.setVisibility(View.VISIBLE);
                }else{
                    searchResult.setText("총 0개의 결과를 찾았습니다");
                    test.setVisibility(View.GONE);
                }

        }
    }
}