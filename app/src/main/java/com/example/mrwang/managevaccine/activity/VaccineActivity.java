package com.example.mrwang.managevaccine.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.Tag;
import android.os.*;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mrwang.managevaccine.JSONTOOL;
import com.example.mrwang.managevaccine.MyTextListener;
import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.adapter.BookAdapter;
import com.example.mrwang.managevaccine.entity.Vaccine;
import com.example.mrwang.managevaccine.global.UrlGlobal;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VaccineActivity extends AppCompatActivity {

    private static final String TAG = "hhhhhhhhhhhhhhhhhh";
    private List<Vaccine> bookList = new ArrayList<>();
    private BookAdapter adapterListView;
    private ListView listView;
    List<String> functionlist = new ArrayList<>();
    List<String> objectVaccinelist = new ArrayList<>();
    List<String> standardlist = new ArrayList<>();
    List<String> taboolist = new ArrayList<>();
    List<String> untowardEffectlist = new ArrayList<>();
    String s;
    UrlGlobal urlGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        requestData();

    }

    /**
     * 获取疫苗信息，并设置Listview点击事件
     */
    private void requestData(){

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();

        Bundle  bundle;
        Vaccine book;
        final String  []str = null;
        int p;
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        String[] s1 = new String[]{};
                        Log.i(TAG, "handleMessage: ");
                        Toast.makeText(VaccineActivity.this, "网络连接成功", Toast.LENGTH_LONG).show();
                        List<HashMap<String,String>> mapList = JSONTOOL.analyze_some_json(msg.obj.toString());
                        for(int i=0;i<mapList.size();i++){
                            Vaccine vaccine = new Vaccine(R.mipmap.book,mapList.get(i).get("name"),mapList.get(i).get("function"));
                            String function = mapList.get(i).get("function");
                            String objectVaccine = mapList.get(i).get("objectVaccine");
                            String standard = mapList.get(i).get("standard");
                            String taboo = mapList.get(i).get("taboo");
                            String untowardEffect = mapList.get(i).get("untowardEffect");
                            bookList.add(vaccine);
                            functionlist.add(function);
                            objectVaccinelist.add(objectVaccine);
                            standardlist.add(standard);
                            taboolist.add(taboo);
                            untowardEffectlist.add(untowardEffect);
                        }
                        initData();
                        break;
                    case 0:
                        Toast.makeText(VaccineActivity.this, "网络连接失败", Toast.LENGTH_LONG).show();;//淇℃伅妗?
                        break;
                }
                super.handleMessage(msg);
            }
        };
        params.put("method", "POST");
        client.post("http://"+urlGlobal.Murl+":8080/vaccine_function/client_list",params,
                new MyTextListener(handler, 1, 0));
    }

    /**
     * 初始化适配器，添加适配器
     */
    private void initData() {

        adapterListView = new BookAdapter(VaccineActivity.this,R.layout.book_item,bookList);
        listView = (ListView)findViewById(R.id.list_view_book);
        listView.setAdapter(adapterListView);
        //设置listview点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Vaccine book;
            Intent intent;
            Bundle bundle;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        bundle=new Bundle();
                        bundle.putString("function", functionlist.get(i));
                        bundle.putString("objectVaccine", objectVaccinelist.get(i));
                        bundle.putString("standard", standardlist.get(i));
                        bundle.putString("taboo", taboolist.get(i));
                        bundle.putString("untowardEffect", untowardEffectlist.get(i));
                        intent= new Intent(VaccineActivity.this,MessageActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
            }
        });
    }
}

