package com.example.mrwang.nbademo2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceActivity extends AppCompatActivity {
    private ListView list_item = null;

    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        list_item = (ListView)findViewById(R.id.list_item);
        intent = getIntent();
        Bundle  bundle = intent.getExtras();
        List<HashMap<String,String>>  list = (List<HashMap<String, String>>) bundle.getSerializable("race");



    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               