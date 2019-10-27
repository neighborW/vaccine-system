package com.example.mrwang.managevaccine.bookfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mrwang.managevaccine.JSONTOOL;
import com.example.mrwang.managevaccine.MyTextListener;
import com.example.mrwang.managevaccine.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.mrwang.managevaccine.R.layout.fragment_book;


public class bookFragment extends Fragment {
    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    boolean b = true;
    String result;

    private  EditText book_name = null;
    private  EditText book_contact = null;
    private  EditText editRe1  =null;
    private  EditText vaccine = null;
    //private  Spinner adress = null;
    private Button book_yuyue = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(fragment_book, container, false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        book_name = (EditText)getView().findViewById(R.id.book_name) ;
        book_contact = (EditText)getView().findViewById(R.id.book_contact);
        //editRe1 = (EditText)getView().findViewById(R.id.editRe1);
        vaccine = (EditText)getView().findViewById(R.id.vaccine);

        spinner = (Spinner)getView(). findViewById(R.id.adress);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (b){
                    view.setVisibility(View.INVISIBLE);
                }
                else {
                    result = adapterView.getItemAtPosition(i).toString();
                    System.out.println(result);
                }
                b = false;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        book_yuyue = (Button)getView().findViewById(R.id.book_yuyue);
        book_yuyue.setOnClickListener(new Booklisenter());
    }
    class Booklisenter implements  View.OnClickListener{
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        HashMap map = JSONTOOL.analyze_once_json(msg.obj.toString());
                        Toast.makeText(getActivity(), "添加成功,请等待工作人员通知", Toast.LENGTH_LONG).show();//淇℃伅妗?
                        break;
                    case 0:
                        Toast.makeText(getActivity(), "添加失败", Toast.LENGTH_LONG).show();//淇℃伅妗?

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
            params.put("name", book_name.getText().toString());
            params.put("phoneNum", book_contact.getText().toString());
            params.put("vaccineName", vaccine.getText().toString());
            params.put("location",result);

                client.post("http://10.0.116.13:8080/appointment/client_appointment", params,
                        new MyTextListener(handler, 1, 0));
        }
    }
}
