package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserActivity extends AppCompatActivity {
        Button BtnAddUser;
        EditText EtUserID, EtPwd, EtName;

        public String setTenLenString(String sInput) { // "1234" => "1234    "
            String sReturn = sInput;
            int nCount = 10 - sReturn.length();
            for (int i = 0; i < nCount; i++) {
                sReturn += " ";
            }
            return sReturn;

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        BtnAddUser = findViewById(R.id.btn_AddUser);
        EtUserID = findViewById(R.id.edt_UserID);
        EtPwd = findViewById(R.id.edt_Pwd);
        EtName = findViewById(R.id.edt_Name);

        BtnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream FoMyFile = openFileOutput("Class2User.txt", Context.MODE_PRIVATE);

                    String sUser = EtUserID.getText().toString().trim();
                    String sPwd = EtPwd.getText().toString().trim();
                    String sName = EtName.getText().toString().trim();

                    sUser = setTenLenString(sUser);
                    sPwd = setTenLenString(sPwd);
                    sName = setTenLenString(sName);

                    FoMyFile.write(sUser.getBytes(), 0, sUser.length());
                    FoMyFile.write(sPwd.getBytes(), 0, sPwd.length());
                    FoMyFile.write(sName.getBytes(), 0, sName.length());

                    FoMyFile.close();

                    Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}