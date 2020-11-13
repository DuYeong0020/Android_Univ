package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubRervActivity extends AppCompatActivity {
    TextView TvResult;
    int nTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_rerv);

        TvResult = findViewById(R.id.tv_Result);
        String sTime="";
        String sName="";

        Intent MyIntent = getIntent();

        nTime = MyIntent.getIntExtra("time", 0);
        sName = MyIntent.getStringExtra("name");

        if(nTime == 0){
            sTime = sName+" 은 일찍 끝내고 싶지 않다.";
        }else{
            sTime = sName+" 은 "+ nTime + "시간 시간 일찍 끝내고 싶다.";
        }
        TvResult.setText(sTime);
    }
}