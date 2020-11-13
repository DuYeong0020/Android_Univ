package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    EditText EtLoginID, EtLoginPWD;
    Button BtnLoginOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EtLoginID = findViewById(R.id.et_LoginID);
        EtLoginPWD = findViewById(R.id.et_LoginPwd);
        BtnLoginOK = findViewById(R.id.btn_LoginOK);

        BtnLoginOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream FiMyFile = openFileInput("Class2User.txt");
                    byte[] baUser = new byte[10];
                    byte[] baPwd = new byte[10];
                    byte[] baName = new byte[10];

                    FiMyFile.read(baUser);
                    FiMyFile.read(baPwd);
                    FiMyFile.read(baName);

                    String sRUser = new String(baUser);
                    String sRPwd = new String(baPwd);
                    String sRName = new String(baName);

                    // 입력한 로그인 정보 저장
                    String sLoginID = EtLoginID.getText().toString().trim();
                    String sLoginPWD = EtLoginPWD.getText().toString().trim();

                    if (sLoginID.equals(sRUser.trim())) {
                        if (sLoginPWD.equals(sRPwd.trim())) {
                            Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "비번 틀림", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "회원가입하세요", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}