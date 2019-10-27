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

public class ChangeActivity extends AppCompatActivity {

    private EditText Cusername = null;
    private EditText oldpassword = null;
    private  EditText newpassword = null;
    private EditText newpassword1 = null;
    private Button change = null;
    UrlGlobal urlGlobal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Cusername = (EditText)findViewById(R.id.Cusername);
        oldpassword = (EditText)findViewById(R.id.oldpassword);
        newpassword = (EditText)findViewById(R.id.newpassword);
        newpassword1 = (EditText)findViewById(R.id.newpassword1);

        change = (Button)findViewById(R.id.change);
        change.setOnClickListener(new ChnageLisenter());
    }
    class ChnageLisenter implements View.OnClickListener {
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        HashMap<String,String> map = JSONTOOL.analyze_once_json(msg.obj.toString());
                        String status=map.get("status");
                        if(status.equals("0")) {
                            Toast.makeText(ChangeActivity.this,"账号或者密码错误，请检查账号或者密码！", Toast.LENGTH_LONG).show();
                        }
                        if(status.equals("1")){
                            Toast.makeText(ChangeActivity.this,"修改成功！", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ChangeActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        break;
                    case 0:
                        Toast.makeText(ChangeActivity.this, "网络错误！", Toast.LENGTH_LONG).show();//淇℃伅妗?
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
            params.put("account", Cusername.getText().toString());
            params.put("old", oldpassword.getText().toString());
            params.put("new1",newpassword.getText().toString());
            params.put("new2",newpassword1.getText().toString());
            System.out.println("3453425");
            client.post("http://"+urlGlobal.Murl+":8080/user/client_change_password", params,
                    new MyTextListener(handler, 1, 0));
        }
    }
}
