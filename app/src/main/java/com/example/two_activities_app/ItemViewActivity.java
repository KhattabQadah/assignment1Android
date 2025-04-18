package com.example.two_activities_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classes.User;
import com.example.classes.UserManager;
import com.example.two_activities_app.databinding.ActivityMainBinding;
import com.example.two_activities_app.databinding.ItemViewBinding;

public class ItemViewActivity extends AppCompatActivity {
    ItemViewBinding binding;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ItemViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        Intent intent  = this.getIntent();
        user = UserManager.getUser();
        if(intent!=null){
            String name = intent.getStringExtra("name");
            String price = intent.getStringExtra("price");
            int id = intent.getIntExtra("id",0);
            int image = intent.getIntExtra("image", R.drawable.dvd);
            binding.itemname.setText(name);
            binding.itemprice.setText(price);
            binding.itemPic1.setImageResource(image);
           binding.buybtnid.setOnClickListener(view -> {
                if (user != null) {
                    if(user.getCart().AddToCart(id, user.getItems())){
                        Toast.makeText(this, user.getItems().get(id-1).getItemName()+" added to cart", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Item sold out", Toast.LENGTH_SHORT).show();
                    }


               }
          });
            binding.rentbtnid.setOnClickListener(view -> {
                if (user != null) {
                    if(user.getCart().AddToCart(id, user.getItems())){
                        Toast.makeText(this, user.getItems().get(id-1).getItemName()+" added to cart", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Item sold out", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }
    }






}