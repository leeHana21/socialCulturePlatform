package com.example.livinglab_cultureplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class review_write extends AppCompatActivity {
    EditText reviewPlace, reviewDate, reviewpNum, reviewTitle, reviewContent;
    ImageView reviewSubmit;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_write);
        reviewPlace = findViewById(R.id.reviewPlace);
        reviewDate = findViewById(R.id.reviewDate);
        reviewpNum = findViewById(R.id.reviewpNum);
        reviewTitle = findViewById(R.id.reviewTitle);
        reviewContent = findViewById(R.id.reviewContent);
        reviewSubmit = findViewById(R.id.reviewSubmit);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("review");
        reviewSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = reviewTitle.getText().toString();
                String pNum = reviewpNum.getText().toString();
                String place = reviewPlace.getText().toString();
                String content = reviewContent.getText().toString();
                String date = reviewDate.getText().toString();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("title",title);
                map.put("pNum",pNum);
                map.put("place",place);
                map.put("content",content);
                map.put("date",date);
                mReference.push().setValue(map);
                //isDestroyed();
                onBackPressed();
            }
        });
    }

}
