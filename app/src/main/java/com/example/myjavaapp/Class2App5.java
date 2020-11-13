package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Class2App5 extends AppCompatActivity {
    RadioButton Rb_S, Rb_R, Rb_P;
    CheckBox Ch_S, Ch_R, Ch_P;
    Button Btn_Start;
    TextView Tv_Result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class2_app5);
        Rb_S = (RadioButton) findViewById(R.id.rb_S);
        Rb_R = (RadioButton) findViewById(R.id.rb_R);
        Rb_P = (RadioButton) findViewById(R.id.rb_P);

        Ch_R = (CheckBox) findViewById(R.id.ch_R);
        Ch_S = (CheckBox) findViewById(R.id.ch_S);
        Ch_P = (CheckBox) findViewById(R.id.ch_P);

        Btn_Start = (Button) findViewById(R.id.btn_Start);
        Tv_Result = (TextView) findViewById(R.id.tv_Result);

        Ch_R.setVisibility(View.GONE);
        Ch_S.setVisibility(View.GONE);
        Ch_P.setVisibility(View.GONE);
        Btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nUser = 0, nCom = 0;
                String sResult="";
                Ch_P.setChecked(false);
                Ch_S.setChecked(false);
                Ch_R.setChecked(false);
                if (Rb_S.isChecked()) {
                    nUser = 1;
                } else if (Rb_R.isChecked()) {
                    nUser = 2;
                } else if (Rb_P.isChecked()) {
                    nUser = 3;
                }
                nCom = (int) (Math.random() * 3) + 1;
                if (nCom == 1) {
                    Ch_S.setChecked(true);
                    Ch_S.setVisibility(View.VISIBLE);
                    Ch_R.setVisibility(View.GONE);
                    Ch_P.setVisibility(View.GONE);
                }
                else if (nCom == 2) {
                    Ch_R.setChecked(true);
                    Ch_R.setVisibility(View.VISIBLE);
                    Ch_P.setVisibility(View.GONE);
                    Ch_S.setVisibility(View.GONE);
                }
                else if (nCom == 3) {
                    Ch_P.setChecked(true);
                    Ch_P.setVisibility(View.VISIBLE);
                    Ch_R.setVisibility(View.GONE);
                    Ch_S.setVisibility(View.GONE);
                }
                switch(nUser-nCom) {
                    case 2:case -1: {
                        sResult = "컴퓨터 승";
                        break;
                    }
                    case 1: case -2: {
                        sResult = "사용자 승";
                        break;
                    }
                    case 0:
                        sResult="비김";
                        break;
                }
                Tv_Result.setText(sResult);

            }
        });
    }
}