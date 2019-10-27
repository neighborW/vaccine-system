package com.example.mrwang.managevaccine.adapter;

import android.content.Context;

import android.view.*;

import android.widget.*;

import java.util.LinkedList;
import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.entity.Share;

import java.util.LinkedList;

public class ShareBase extends BaseAdapter {
    private LinkedList<Share> mData;
    private Context mContext;
    public ShareBase(LinkedList<Share> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return  mData.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.share,parent,false);

        TextView txt_aName = (TextView) convertView.findViewById(R.id.txt_content);
        txt_aName.setText(mData.get(position).getName());

        ImageView txt_aImage = (ImageView)convertView.findViewById(R.id.txt_image);
        txt_aImage.setImageResource(mData.get(position).getImage());



        return convertView;
    }
}

