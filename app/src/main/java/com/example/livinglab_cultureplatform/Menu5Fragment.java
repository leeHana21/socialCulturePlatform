package com.example.livinglab_cultureplatform;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu5Fragment  extends Fragment implements View.OnClickListener {
    LinearLayout myStory_extend, notice_extend, customerService_extend, configSet_extend;
    TextView myStory, notice, customerService, configSet;
    ImageView profile_edit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu5_setting, container, false);
        myStory_extend = view.findViewById(R.id.myStory_extend);
        notice_extend = view.findViewById(R.id.notice_extend);
        customerService_extend = view.findViewById(R.id.customerService_extend);
        configSet_extend = view.findViewById(R.id.configSet_extend);
        myStory = view.findViewById(R.id.myStory);
        notice = view.findViewById(R.id.notice);
        customerService = view.findViewById(R.id.customerService);
        configSet = view.findViewById(R.id.configSet);
        profile_edit = view.findViewById(R.id.profile_edit);

        profile_edit.setOnClickListener(this);
        myStory.setOnClickListener(this);
        myStory_extend.setOnClickListener(this);
        notice.setOnClickListener(this);
        notice_extend.setOnClickListener(this);
        customerService.setOnClickListener(this);
        customerService_extend.setOnClickListener(this);
        configSet.setOnClickListener(this);
        configSet_extend.setOnClickListener(this);
        return view;

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.profile_edit:
                Intent intent0 = new Intent(getActivity(), my_info_edit.class);
                startActivity(intent0);
                break;
            case R.id.myStory:
            case R.id.myStory_extend:
                Intent intent = new Intent(getActivity(),my_story_edit.class);
                startActivity(intent);
                break;
            case R.id.notice:
            case R.id.notice_extend:
                Intent intent2 = new Intent(getActivity(),app_notice.class);
                startActivity(intent2);
                break;
            case R.id.customerService:
            case R.id.customerService_extend:
                Intent intent3 = new Intent(getActivity(),app_callcenter.class);
                startActivity(intent3);
                break;
            case R.id.configSet:
            case R.id.configSet_extend:
                Intent intent4 = new Intent(getActivity(),app_setting.class);
                startActivity(intent4);
                break;
        }
    }
}
