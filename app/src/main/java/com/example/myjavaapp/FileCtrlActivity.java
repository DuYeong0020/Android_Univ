package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCtrlActivity extends AppCompatActivity {
    Button BtnWrite, BtnRead, BtnUserForm, BtnLoginForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_ctrl);

        BtnLoginForm = findViewById(R.id.btn_LoinForm);
        BtnUserForm = findViewById(R.id.btn_UserForm);
        BtnRead = findViewById(R.id.btn_FRead);
        BtnWrite = findViewById(R.id.btn_FWrite);

        BtnLoginForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });
        BtnUserForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FileCtrlActivity.this, UserActivity.class);
                startActivity(myIntent);
            }
        });

        BtnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream FoMyFile = openFileOutput("UserFile.txt", Context.MODE_PRIVATE);

                    String sUser = "12345678";
                    String sPwd = "abcd";

                    FoMyFile.write(sUser.getBytes(),0 , sUser.length());
                    FoMyFile.write(sPwd.getBytes(), 0, 4);
                    FoMyFile.close();

                    Toast.makeText(getApplicationContext(), "UserFile.txt OK", Toast.LENGTH_SHORT).show();

                }catch (IOException e) {

                }
            }
        });
        BtnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream FiMyFile = openFileInput("UserFile.txt");
                    byte[] baUser = new byte[8];
                    byte[] baPwd = new byte[4];

                    FiMyFile.read(baUser);
                    FiMyFile.read(baPwd);

                    String sRUser = new String(baUser);
                    String sRPwd = new String(baPwd);

                    Toast.makeText(getApplicationContext(), sRUser, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), sRPwd, Toast.LENGTH_SHORT).show();

                    FiMyFile.close();

                }catch (Exception io) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}