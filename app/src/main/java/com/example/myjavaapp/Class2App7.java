package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Class2App7 extends AppCompatActivity {
    Button BtnLayout, BtnFileCtrl, BtnIntentCtrl, BtnDrawTest, BtnTouchCtrl, BtnDrawCtrl;
    EditText EtTest;
    Button BtnHttpGetTest;
    private long lastTimeBackProcessed;
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        if(System.currentTimeMillis() - lastTimeBackProcessed<1500) {
            finish();
            return;
        }
        lastTimeBackProcessed = System.currentTimeMillis();
        Toast.makeText(this, "한번 더 클릭하면 종료합니다.",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class2_app7);

        BtnFileCtrl = findViewById(R.id.btn_FileCtrl);
        BtnLayout = findViewById(R.id.btn_Layout);
        BtnIntentCtrl = findViewById(R.id.btn_IntentCtrl);
        EtTest = findViewById(R.id.et_Test);
        BtnDrawTest = findViewById(R.id.btn_DrawTest);
        BtnHttpGetTest = findViewById(R.id.btn_HttpGetTest);
        BtnTouchCtrl = findViewById(R.id.btn_TouchCtrl);
        BtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Class2App7.this, LayoutActivity.class);
                startActivity(myintent);
            }
        });
        BtnFileCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(getApplicationContext(), FileCtrlActivity.class);
                startActivity(myintent);
            }
        });
        BtnIntentCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSendStr = EtTest.getText().toString().trim();
                // 인텐트 생성
                Intent myIntent = new Intent(getApplicationContext(), SubIntentActivity.class);

                myIntent.putExtra("mMyTxt", sSendStr);
                // 인텐트 실행
                startActivity(myIntent);
            }
        });

        BtnDrawTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyIntent = new Intent(getApplicationContext(), DrawCtrlActivity.class);
                startActivity(MyIntent);
            }
        });
        BtnHttpGetTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), HGetActivity.class);

                // 인텐트 실행
                startActivity(myIntent);
            }
        });
        BtnTouchCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyIntent = new Intent(getApplicationContext(), TouchCtrlActivity.class);
                startActivity(MyIntent);
            }
        });


    }
}