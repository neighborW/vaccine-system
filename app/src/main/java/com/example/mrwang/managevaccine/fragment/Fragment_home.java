package com.example.mrwang.managevaccine.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mrwang.managevaccine.activity.BookActivity;
import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.activity.VaccineActivity;

/**
 * 首页的fragment
 */
    public class Fragment_home extends Fragment {
    private Button book = null;
    private Button knowlage = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_home, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        book = (Button) getView().findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), BookActivity.class);
                startActivity(intent);
            }
        });
        knowlage = (Button)getView().findViewById(R.id.knowlage);
        knowlage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VaccineActivity.class);
                startActivity(intent);
            }
        });
    }
}
