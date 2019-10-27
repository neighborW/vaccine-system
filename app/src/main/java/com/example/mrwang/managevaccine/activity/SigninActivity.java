package com.example.mrwang.managevaccine.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mrwang.managevaccine.JSONTOOL;
import com.example.mrwang.managevaccine.MyTextListener;
import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.global.UrlGlobal;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;

public class SigninActivity extends AppCompatActivity {

    private EditText signin_name = null;
    private  EditText signin_pasword = null;
    private EditText confirm  =null;
    private Button sinninBtn = null;

    UrlGlobal urlGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signin_name = (EditText)findViewById(R.id.signin_name);
        signin_pasword = (EditText)findViewById(R.id.signin_pasword);
        sinninBtn = (Button)findViewById(R.id.sinninBtn);

        sinninBtn.setOnClickListener(new SinLisener());

    }

    /**
     * 获取添加一个用户请求，即插入一个用户
     */
   class SinLisener implements View.OnClickListener{
       @SuppressLint("HandlerLeak")
       Handler handler = new Handler() {
           public void handleMessage(Message msg) {
               switch (msg.what) {
                   case 1:
                       HashMap<String,String> map = JSONTOOL.analyze_once_json(msg.obj.toString());
                       String status=map.get("status");
                       if(status.equals("0")) {
                           Toast.makeText(SigninActivity.this,"账号已存在，重新输入", Toast.LENGTH_LONG).show();
                       }
                       if(status.equals("1")){
                           Toast.makeText(SigninActivity.this,"注册成功！", Toast.LENGTH_LONG).show();
                           Intent intent = new Intent(SigninActivity.this, LoginActivity.class);
                           startActivity(intent);
                           SigninActivity.this.finish();
                       }
                       break;
                   case 0:
                       Toast.makeText(SigninActivity.this, "网络错误", Toast.LENGTH_LONG).show();//淇℃伅妗?
                       break;
               }
               super.handleMessage(msg);
           }
       };
       @Override
       public void onClick(View v) {
           AsyncHttpClient client = new AsyncHttpClient();
           RequestParams params = new RequestParams();
           params.put("method", "POST");
           params.put("type","ordinary");
           params.put("account", signin_name.getText().toString());//匹配输入框输入的数据
           params.put("password", signin_pasword.getText().toString());
           String  password1 = null;
           String password2 = null;
           password1 = (String) confirm.getText().toString();
           password2 = (String) signin_pasword.getText().toString();

           System.out.println(password1);
           System.out.println(password2);
           if(password1.equals(password2) )//密码与确认密码一致的话，即可确定，反之则显示错误
           {
               client.post("http://"+urlGlobal.Murl+":8080/user/client_register", params,
                       new MyTextListener(handler, 1, 0));
           }
           else {
               Toast.makeText(SigninActivity.this, "密码不一致", Toast.LENGTH_LONG).show();//淇℃伅妗?
           }
       }
   }
}
