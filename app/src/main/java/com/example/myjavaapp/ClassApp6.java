package com.example.myjavaapp;
// 여기부터 기말고사 범위임
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;

public class ClassApp6 extends AppCompatActivity {
    Button BtnSub1, BtnSub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_app6);
        BtnSub1=findViewById(R.id.btn_sub1);
        BtnSub2=findViewById(R.id.btn_sub2);
        BtnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyIntent = new Intent(getApplicationContext(), Sub1Activity.class); // 메인 액티비티에서 이동할때는 MainActivity.this
                startActivity(MyIntent);
            }
        });
        BtnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyIntent = new Intent(getApplicationContext(), Sub2Activity.class); // 메인 액티비티에서 이동할때는 MainActivity.this
                startActivity(MyIntent);
            }
        });
    }

}