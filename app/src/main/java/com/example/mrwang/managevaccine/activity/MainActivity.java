package com.example.mrwang.managevaccine.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.fragment.Fragment_dynamic;
import com.example.mrwang.managevaccine.fragment.Fragment_home;

public class MainActivity extends AppCompatActivity {
    private Button page_home = null;
    //private Button page_zoning = null;
    private Button page_info = null;
    private Button page_dynamic = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page_home = (Button)findViewById(R.id.page_home);
        page_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment_home fragment_home = new Fragment_home();
                ft.replace(R.id.fragment_container,fragment_home);
                ft.commit();
            }
        });


        page_dynamic = (Button)findViewById(R.id.page_dynamic) ;
        page_dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment_dynamic fragment_dynamic = new Fragment_dynamic();
                ft.replace(R.id.fragment_container,fragment_dynamic);
                ft.commit();
            }
        });

        page_info = (Button)findViewById(R.id.page_info);
        page_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BaiduMapActivity.class);
                startActivity(intent);
            }
        });

    }
}
