package com.example.two_activities_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classes.Items;
import com.example.classes.ListAdapter;
import com.example.classes.User;
import com.example.classes.UserManager;
import com.example.two_activities_app.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Items> itemList = new ArrayList<Items>();
    User user;
    ListAdapter adapter;
    String json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String json = prefs.getString("userKey", null);

       if (json != null) {
            Gson gson = new Gson();
            User savedUser = gson.fromJson(json, User.class);
            user = savedUser;
        }
       else{
           user = new User("hello123","Maxi");
       }



        fillData();

         adapter = new ListAdapter(MainActivity.this,itemList,user);
        user.setItems(itemList);
        UserManager.setUser(user);




        binding.listview.setAdapter(adapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ItemViewActivity.class);
                Items clicked =(Items) parent.getItemAtPosition(position);
                intent.putExtra("name", clicked.getItemName());
                intent.putExtra("price", clicked.getPrice());
                intent.putExtra("image", clicked.getImages());
                intent.putExtra("id", clicked.getId());
              //  intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        binding.SearchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



            }

            @Override
            public void afterTextChanged(Editable s) {
                   String searchBarText = String.valueOf(binding.SearchBar.getText());
                   ArrayList<Items> foundkeys = Search(itemList,searchBarText);
                   if(foundkeys.size()>0){
                       ListAdapter searchAdapter = new ListAdapter(MainActivity.this,foundkeys,user);
                       binding.listview.setAdapter(searchAdapter);
                   }
            }
        });

        FloatingActionButton fabCart = binding.fabCart;

        fabCart.setOnClickListener(view -> {

            Intent intent2 = new Intent(MainActivity.this, CartActivity.class);

            startActivity(intent2);
        });





    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ListAdapter(MainActivity.this,itemList,user);
        binding.listview.setAdapter(adapter);
    }
    @Override
    protected void onPause(){
        super.onPause();
        Gson gson = new Gson();
        json = gson.toJson(user);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        prefs.edit().putString("userKey", json).apply();
    }




    public void fillData(){
        Items item = new Items("flashlight","50",R.drawable.flashlight);
        Items item1 = new Items("gloves","100",R.drawable.gloves);
        Items item2 = new Items("paper","20",R.drawable.paper);
        Items item3 = new Items("pants","66",R.drawable.pants);
        Items item4 = new Items("dvd","34",R.drawable.dvd);
        Items item5 = new Items("bottle","12",R.drawable.bottle);
        Items item6 = new Items("flags","5",R.drawable.flags);
        Items item7 = new Items("Iphone","5600",R.drawable.iphone);
        Items item8 = new Items("IphoneCase","25",R.drawable.iphonecase);
        Items item9 = new Items("PowerSupply","350",R.drawable.powersupply);
        Items item10 = new Items("matress","650",R.drawable.mattress);
        Items item11 = new Items("LED Lights","140",R.drawable.ledlights);
        Items item12 = new Items("shirt","45",R.drawable.images);
        Items item13 = new Items("jacket","90",R.drawable.jacket);

        itemList.add(item);
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);
        itemList.add(item10);
        itemList.add(item11);
        itemList.add(item12);
        itemList.add(item13);
    }
    public ArrayList<Items> Search(ArrayList<Items> items,String key){
        ArrayList<Items> foundkeys = new ArrayList<Items>();
        for(int i=0;i<items.size();i++){

           if( items.get(i).getItemName().startsWith(key)){
               foundkeys.add(items.get(i));

           }
        }
        return foundkeys;
    }



}