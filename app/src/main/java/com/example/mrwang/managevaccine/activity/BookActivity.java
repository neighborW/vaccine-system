package com.example.mrwang.managevaccine.activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.bookfragment.BookmanFragment;
import com.example.mrwang.managevaccine.bookfragment.bookFragment;

/**
 * 预约界面
 */
public class BookActivity extends AppCompatActivity {

    private Button page_book = null;
    private  Button page_manage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        page_book = (Button)findViewById(R.id.page_book);
        page_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                bookFragment fragment_book = new  bookFragment();
                ft.replace(R.id.fragment_b,fragment_book);
                ft.commit();
            }
        });
        page_manage = (Button)findViewById(R.id.page_del);
        page_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                BookmanFragment fragment_bookman = new  BookmanFragment();
                ft.replace(R.id.fragment_b,fragment_bookman);
                ft.commit();
            }
        });
    }
}
