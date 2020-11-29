package com.example.livinglab_cultureplatform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class gatheringWrite extends AppCompatActivity {
    Spinner chooseCategory;
    Button chooseDate, choosePhoto;
    EditText wirtePlace, writeNum, writePrice, writeTitle, writeContent;
    ImageView gatheringSubmit;
    Object category;
    String dateMessage;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gathering_write);
        chooseCategory = findViewById(R.id.chooseCategory);
        chooseDate = findViewById(R.id.chooseDate);
        choosePhoto = findViewById(R.id.choosePhoto);
        wirtePlace = findViewById(R.id.writePlace);
        writeNum = findViewById(R.id.writeNum);
        writePrice = findViewById(R.id.writePrice);
        writeTitle = findViewById(R.id.writeTitle);
        writeContent = findViewById(R.id.writeContent);
        gatheringSubmit = findViewById(R.id.gatheringSubmit);


        chooseCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
                chooseDate.setTextColor(Color.BLACK);
                chooseDate.setText(dateMessage);
            }
        });


        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("gathering");
        gatheringSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = writeTitle.getText().toString();
                String price = writePrice.getText().toString();
                String pNum = writeNum.getText().toString();
                String place = wirtePlace.getText().toString();
                String content = writeContent.getText().toString();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("title",title);
                map.put("price",price);
                map.put("peopleNum",pNum);
                map.put("place",place);
                map.put("content",content);
                map.put("category",category);
                map.put("date", dateMessage);
                mReference.push().setValue(map);
                isDestroyed();
                Intent intent = new Intent(getApplicationContext(),menu2_gathering.class);
                startActivity(intent);
            }
        });
        finishActivity(0);


    }
    public void showDatePicker() {
        DialogFragment newFragment = new SelectDateFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        dateMessage = (month_string + "/" + day_string + "/" + year_string);

        Toast.makeText(this,"Date: "+dateMessage,Toast.LENGTH_SHORT).show();
    }
}
