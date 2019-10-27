package com.example.mrwang.managevaccine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mrwang.managevaccine.R;
import com.example.mrwang.managevaccine.entity.Vaccine;

import java.util.List;


public class  BookAdapter extends ArrayAdapter<Vaccine> {

    private int resourceId;

    public BookAdapter(Context context, int resource, List<Vaccine> bookList ) {
        super(context, resource, bookList);
         resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vaccine book = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)view.findViewById(R.id.book_item_image);
            viewHolder.name = (TextView)view.findViewById(R.id.book_item_name);
            viewHolder.author = (TextView)view.findViewById(R.id.book_item_author);
            view.setTag(viewHolder);//将viewHolder存储在view中
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag(); //重新获取viewHolder
        }
        viewHolder.imageView.setImageResource(book.getImageView());
        viewHolder.name.setText(book.getName());
        viewHolder.author.setText(book.getFunction());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView name;
        TextView author;
    }
}
