package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Tv_Test;
    Button Bt_OK;
    EditText Ed_Name;
    Button Btn_Call;
    Button Btn_Web;
    Button Btn_Photo,Btn_Ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Tv_Test=(TextView)findViewById(R.id.tvTest);
        Bt_OK=(Button)findViewById(R.id.btnOK);
        Ed_Name=(EditText)findViewById(R.id.edName);
        Btn_Call=(Button)findViewById(R.id.btnCall);
        Btn_Web=(Button)findViewById(R.id.btnWeb);
        Btn_Photo=(Button)findViewById(R.id.btnPhoto);
        Tv_Test.setText("Start");
        Btn_Ctrl=(Button)findViewById(R.id.btnCtrl);

        Bt_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"TEST", Toast.LENGTH_SHORT).show();
            }
        });

        Btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/01099811072"));
                startActivity(MyIntent);
            }
        });
        Btn_Web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(MyIntent);
            }
        });

        Btn_Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(MyIntent);
            }
        });
        Btn_Ctrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String sTemp = Ed_Name.getText().toString();
                // Tv_Test.setText(sTemp);
                Tv_Test.setText(Ed_Name.getText().toString());
            }
        });

    }


}