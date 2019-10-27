package com.example.mrwang.managevaccine.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mrwang.managevaccine.R;

public class MessageActivity extends AppCompatActivity {

    private TextView ed1 = null;
    private TextView ed2 = null;
    private TextView ed3 = null;
    private TextView ed4 = null;
    private TextView ed5 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        //ed1 = (TextView)findViewById(R.id.ed1);
        ed2 = (TextView)findViewById(R.id.ed2);
        ed3 = (TextView)findViewById(R.id.ed3);
        ed4 = (TextView)findViewById(R.id.ed4);
        ed5 = (TextView)findViewById(R.id.ed5);
//        Intent intent=getIntent();
//        Bundle bundle=intent.getExtras();///获取前面的那个activity传过来的数据
        Bundle bundle=getIntent().getExtras();

        //ed1.setText(bundle.getString("name"));
        ed2.setText(bundle.getString("objectVaccine"));
        ed3.setText(bundle.getString("standard"));
        ed4.setText(bundle.getString("taboo"));
        ed5.setText(bundle.getString("untowardEffect"));
    }
}
