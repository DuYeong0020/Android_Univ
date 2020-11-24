package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HGetActivity extends AppCompatActivity {
    Button BtnHSend;
    EditText EtHRestult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_get);
        BtnHSend = findViewById(R.id.btn_HSend);
        EtHRestult = findViewById(R.id.et_HResult);

        BtnHSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sGetURL = "http://218.36.126.200:8082/Class2/class2.asp?sWriter=DuYeong&sOpnion=01099811072";
                new HttpGetTask().execute(sGetURL);
            }
        });
    }
    // Http의 요청으로 텍스트를 서버로부터 다운로드 받는 비동기 태스크
    class HttpGetTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            EtHRestult.setText(s);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            EtHRestult.setText("통신 시작 ...");
        }
        /**
         * 서버와 연결된 스트림으로부터 텍스트를 읽어들입니다.
         * @param in 서버와 연결된 입력 스트림
         * @return 서버로부터 읽은 텍스트
         */
        private String getTextFrom(InputStream in) {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(in));
                // 스트림으로부터 라인 단위로 자료를 읽어 옵니다.
                while (true) {
                    String line = br.readLine();
                    if (null == line) break;
                    sb.append(line + '\n');
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            String downloadedText = null;
            HttpURLConnection connection = null;

            // 주소로부터 URL 객체 생성
            try {
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                //Toast.makeText(getApplicationContext(), "ERROR  1.", Toast.LENGTH_SHORT).show();
                return "사용할 수 있는 인터넷 주소가 아닙니다.";
            }

            // 서버와 연결 고리 생성
            try {
                connection = (HttpURLConnection)url.openConnection();
                if (null == connection) {
                    //Toast.makeText(getApplicationContext(), "ERROR  2.", Toast.LENGTH_SHORT).show();
                    return "연결할 수 없습니다.";
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "IO 예외에 의해 연결할 수 없습니다.";
            }

            // 연결 관련 설정
            try {
                // get방식 통신
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                Toast.makeText(getApplicationContext(), "ERROR  3.", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                return "잘못된 HTTP 요청 메소드입니다.";
            }
            connection.setUseCaches(false);  // 캐싱데이터를 받을지 안받을지
            connection.setConnectTimeout(10000);

            // 서버에 텍스트 다운로드 요청
            try {
                switch (connection.getResponseCode()) {
                    case HttpURLConnection.HTTP_OK:      // 서버로부터 응답을 정상적으로 받은 경우
                        downloadedText = getTextFrom(connection.getInputStream());

                        break;
                    default:   // 그 외의 경우들은 모두 오류로 간주
                        downloadedText = connection.getResponseCode() + " - " + connection.getResponseMessage();
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            connection.disconnect();

            return downloadedText;
        }
    }
}