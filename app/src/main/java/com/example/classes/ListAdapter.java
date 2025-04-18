package com.example.classes;

import android.view.LayoutInflater;
import android.view.View;


import android.content.Context;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.two_activities_app.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Items> {
    private User user;
    public ListAdapter(@NonNull Context context, ArrayList<Items> items, User user) {
        super(context, R.layout.list_item,items);
        this.user = user;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Items item = getItem(position);
        if(convertView == null ){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageview = convertView.findViewById(R.id.item_pic);
        TextView itemName = convertView.findViewById(R.id.itemName);
        TextView itemPrice = convertView.findViewById(R.id.item_price);
        imageview.setImageResource(item.getImages());
        itemPrice.setText("$"+item.getPrice());
        itemName.setText("Product Name: "+ item.getItemName());
        TextView quantity = convertView.findViewById(R.id.quantity);
        quantity.setText("Quantity:"+ Integer.toString(item.getQuantity()));



        return convertView;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
