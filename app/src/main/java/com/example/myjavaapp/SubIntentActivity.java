package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class SubIntentActivity extends AppCompatActivity {
    TextView TvIntent;
    Button BtnResult;
    EditText EtMyMame;
    RadioButton RbOneHour, RbTwoHour, RbThreeHour;
    CheckBox CbEnd;
    int iEnd = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_intent);
        TvIntent = findViewById(R.id.tv_Intent);
        BtnResult = findViewById(R.id.btn_Result);
        EtMyMame = findViewById(R.id.et_MyName);
        RbOneHour = findViewById(R.id.rb_OneHour);
        RbTwoHour = findViewById(R.id.rb_TwoHour);
        RbThreeHour = findViewById(R.id.rb_ThreeHour);
        CbEnd = findViewById(R.id.cb_End);
        Intent MyIntent = getIntent();

        String sMyTxt = MyIntent.getStringExtra("mMyTxt");
        // int nTest = MyIntent.getIntExtra("mMyInt", 0);  문자는 NULL이라도 들어갈 수 있는데 숫자는 NULL이 안되므로 0이 디폴트

        TvIntent.setText(sMyTxt);

        RbOneHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CbEnd.isChecked())
                {
                    iEnd = 1;
                }
            }
        });
        RbTwoHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CbEnd.isChecked())
                {
                    iEnd = 2;
                }
            }
        });
        RbThreeHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CbEnd.isChecked())
                {
                    iEnd = 3;
                }
            }
        });

        BtnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SubIntent = new Intent(getApplicationContext(), SubRervActivity.class);

                SubIntent.putExtra("name", EtMyMame.getText().toString().trim());
                SubIntent.putExtra("time", iEnd);
                startActivity(SubIntent);

            }
        });
    }
}