package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Class2App3 extends AppCompatActivity {

    TextView Tv_Res;
    EditText Ed_1, Ed_2;
    Button Bt_Plus, Bt_result;
    RadioButton Rb_Minus, Rb_Div, Rb_Multi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class2_app3);

        Tv_Res = (TextView) findViewById(R.id.tvRes);
        Ed_1 = (EditText) findViewById(R.id.ed_1);
        Ed_2 = (EditText) findViewById(R.id.ed_2);
        Bt_Plus = (Button) findViewById(R.id.btnPlus);
        Bt_result = (Button) findViewById(R.id.btn_Result);
        Rb_Minus = (RadioButton) findViewById(R.id.rd_Minus);
        Rb_Div = (RadioButton) findViewById(R.id.rd_Div);
        Rb_Multi = (RadioButton) findViewById(R.id.rd_Multi);
        // Rb_Multi.setChecked(true);

        Bt_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sT_1 = Ed_1.getText().toString();
                int nT_1 = Integer.parseInt(sT_1);

                String sT_2 = Ed_2.getText().toString();
                int nT_2 = Integer.parseInt(sT_2);

                String sRes=null;

                int nRes = 0;
                if(Rb_Minus.isChecked())
                {
                    nRes = nT_1 - nT_2;
                }else if(Rb_Div.isChecked()) {
                    nRes = nT_1 / nT_2;
                }
                else if(Rb_Multi.isChecked()) {
                    nRes = nT_1 * nT_2;
                }else  {
                    Toast.makeText(getApplicationContext(), "라디오 버튼을 선택해주세요", Toast.LENGTH_SHORT);
                }
                sRes = Integer.toString(nRes);
                // sRes = String.valueOf(nRes);
                // sRes = nRes+"";
                Tv_Res.setText(sRes);
            }
        });
        Bt_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sT_1 = Ed_1.getText().toString();
                int nT_1 = Integer.parseInt(sT_1);

                String sT_2 = Ed_2.getText().toString();
                int nT_2 = Integer.parseInt(sT_2);

                String sRes=null;

                int nRes = nT_1 + nT_2;

                sRes = Integer.toString(nRes);
                // sRes = String.valueOf(nRes);
                // sRes = nRes+"";
                Tv_Res.setText(sRes);
            }
        });
    }
}