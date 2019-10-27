package com.example.mrwang.managevaccine.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mrwang.managevaccine.JSONTOOL;
import com.example.mrwang.managevaccine.*;
import com.example.mrwang.managevaccine.MyTextListener;
import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.global.UrlGlobal;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn = null;
    private Button resterBtn = null;
    private EditText uesrname = null;
    private EditText password = null;

    static Toast t;
    UrlGlobal urlGlobal;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button)findViewById(R.id.loginBtn);
        resterBtn = (Button)findViewById(R.id.resterBtn);

        uesrname = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        loginBtn.setOnClickListener(new MyLisener());
        resterBtn.setOnClickListener(new MyLisener());
    }

    /**
     * 获取用户表数据请求
     */
    class MyLisener implements View.OnClickListener{
        String s = null;
        @Override
        public void onClick(View v) {
            @SuppressLint("HandlerLeak")
            Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 1:
                            HashMap<String,String> map = JSONTOOL.analyze_once_json(msg.obj.toString());
                            String status=map.get("status");
                            if(status.equals("0")) {
                                Toast.makeText(LoginActivity.this,"账号或者密码错误，请检查账号或者密码！", Toast.LENGTH_LONG).show();
                            }
                            if(status.equals("1")){
                                Toast.makeText(LoginActivity.this,"登陆成功！", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            break;
                        case 0:
                           Toast.makeText(LoginActivity.this, "网络错误", Toast.LENGTH_LONG).show();//淇℃伅妗?
                            break;
                    }
                    super.handleMessage(msg);
                }
            };
            //"http://10.0.116.13:8080/user/client_login"
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
                switch (v.getId()){

                    case R.id.loginBtn:
                        //进行数据匹配，匹配失败则返回失败状态码，登陆失败
                        params.put("method", "POST");
                        params.put("account", uesrname.getText().toString());
                        params.put("password", password.getText().toString());
                        client.post("http://"+urlGlobal.Murl+":8080/user/client_login", params,
                                new MyTextListener(handler, 1, 0));
                        break;
                    case R.id.resterBtn:
                        Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                            startActivity(intent);
                            break;
                }
        }
    }

}