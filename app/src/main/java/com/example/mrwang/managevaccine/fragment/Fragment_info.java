package com.example.mrwang.managevaccine.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.example.mrwang.managevaccine.R;

/**
 * Created by yangwenlong on 2018/5/6.
 */

public class Fragment_info extends Fragment {
    private static final int BAIDU_READ_PHONE_STATE = 100;

    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private LocationClient mlocationClient;
//    private MylocationListener mlistener;
    private Context context;

    private double mLatitude;
    private double mLongitude;
    private float mCurrentX;

    private Button mGetMylocationBN;

    PopupMenu popup = null;

    //自定义图标
    private BitmapDescriptor mIconLocation;

    //private MyOrientationListener myOrientationListener;
    //定位图层显示方式
    private MyLocationConfiguration.LocationMode locationMode;

    public Fragment_info() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu_info, container, false);


    }
//    public void onActivityCreated(Bundle savedInstanceState) {
//
//        super.onActivityCreated(savedInstanceState);
//        SDKInitializer.initialize(context.getApplicationContext());
//        setContentView(R.layout.fragment_menu_info);
//        this.context = this;
//
//        initView();
//        //判断是否为Android 6.0 以上的系统版本，如果是，需要动态添加权限
//        if (Build.VERSION.SDK_INT >= 23) {
//            showLocMap();
//        } else {
//            initLocation();//initLocation为定位方法
//        }
//    }
}
