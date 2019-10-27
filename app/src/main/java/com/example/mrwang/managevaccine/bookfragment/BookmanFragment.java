package com.example.mrwang.managevaccine.bookfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrwang.managevaccine.JSONTOOL;
import com.example.mrwang.managevaccine.MyTextListener;
import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.activity.BookActivity;
import com.example.mrwang.managevaccine.activity.VaccineActivity;
import com.example.mrwang.managevaccine.entity.Vaccine;
import com.example.mrwang.managevaccine.global.UrlGlobal;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;
import java.util.List;


public class BookmanFragment extends Fragment {
    private Button selectBtn,deleteBtn;
    private TextView name,phone,vaccinename,location;
    private EditText selectET;
    UrlGlobal urlGlobal;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookman, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        selectBtn=(Button)getView().findViewById(R.id.selectBtn);
        deleteBtn=(Button)getView().findViewById(R.id.deleteBtn);
        name=(TextView)getView().findViewById(R.id.name) ;
        phone=(TextView)getView().findViewById(R.id.phone);
        vaccinename=(TextView)getView().findViewById(R.id.vaccinename);
        location=(TextView)getView().findViewById(R.id.location);
        selectET=(EditText)getView().findViewById(R.id.selectET);

        selectBtn.setOnClickListener(new MyLisener());
        deleteBtn.setOnClickListener(new MyLisener());
    }

    /**
     * 获取查询疫苗信息请求
     */
    private void selectData(){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        HashMap<String,String> map = JSONTOOL.analyze_once_json(msg.obj.toString());
                        name.setText(map.get("name"));
                        phone.setText(map.get("phoneNum"));
                        vaccinename.setText(map.get("vaccineName"));
                        location.setText(map.get("location"));
                        break;
                    case 0:
                        Toast.makeText(getActivity(), "网络连接失败", Toast.LENGTH_LONG).show();;//淇℃伅妗?
                        break;
                }
                super.handleMessage(msg);
            }
        };
        params.put("method", "POST");
        params.put("name",selectET.getText().toString().trim());
        client.post("http://"+urlGlobal.Murl+":8080/appointment/client_selectByname",params,
                new MyTextListener(handler, 1, 0));
    }

    /**
     * 获取删除预约信息请求
     */
    private void deleteData(){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_LONG).show();
                        break;
                    case 0:
                        Toast.makeText(getActivity(),"删除失败" , Toast.LENGTH_LONG).show();
                        break;
                }
                super.handleMessage(msg);
            }
        };
        params.put("method", "POST");
        params.put("name",selectET.getText().toString().trim());
        client.post("http://"+urlGlobal.Murl+":8080/appointment/client_removeByName",params,//返回状态码
                new MyTextListener(handler, 1, 0));
    }

    /**
     * 监听类
     */
    class MyLisener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.selectBtn:
                    selectData();
                    break;
                case R.id.deleteBtn:
                    deleteData();
                    break;

            }
        }
    }
}
