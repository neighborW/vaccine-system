package com.example.mrwang.managevaccine.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.activity.ChangeActivity;
import com.example.mrwang.managevaccine.activity.LoginActivity;
import com.example.mrwang.managevaccine.adapter.ShareBase;
import com.example.mrwang.managevaccine.entity.Share;

import java.util.LinkedList;
import java.util.List;

public class Fragment_dynamic extends Fragment {

    private List mData = null;
    private Context mContext;
    private ShareBase mAdapter = null;
    private ListView list_share;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_dynamic, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
    private void init() {
        mContext = getActivity();
        list_share = (ListView) getView().findViewById(R.id.message_list);
        mData = new LinkedList<Share>();
        mData.add(new Share("点我登陆",R.mipmap.wode48));
        mData.add(new Share("修改密码",R.mipmap.youjiantou48));
        mData.add(new Share("软件分享",R.mipmap.youjiantou48));
        mData.add(new Share("选择城市",R.mipmap.youjiantou48));
        mData.add(new Share("联系客服",R.mipmap.launcher));
        mAdapter = new ShareBase((LinkedList<Share>) mData, mContext);

        list_share.setAdapter(mAdapter);//设置监听
        list_share.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        Intent intent1 = new Intent(getActivity(), ChangeActivity.class);
                        startActivity(intent1);
                        break;
//                    case 2:
//                        Uri uri2 = Uri.parse("https://hao.360.cn");
//                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
//                        startActivity(intent2);
//                        break;
//                    case 3:
//                        Uri uri3 = Uri.parse("https://hao.360.cn");
//                        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
//                        startActivity(intent3);
//                        break;
//                    case 4:
//                        Uri uri4 = Uri.parse("https://hao.360.cn");
//                        Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);
//                        startActivity(intent4);
//                        break;
               }
            }
        });
    }

}
