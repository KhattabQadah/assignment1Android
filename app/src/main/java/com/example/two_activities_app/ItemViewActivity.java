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
    int quant;
    int id; 
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ItemViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         quant=1;


        Intent intent  = this.getIntent();
        user = UserManager.getUser();
        if(intent!=null){
            String name = intent.getStringExtra("name");
            String price = intent.getStringExtra("price");

             id = intent.getIntExtra("id",0);
            int image = intent.getIntExtra("image", R.drawable.dvd);
            binding.itemPic1.setImageResource(image);
            binding.itemNameView.setText(user.getItems().get(id-1).getItemName());
            binding.totalItemPrice.setText("$"+quant*Integer.parseInt(user.getItems().get(id-1).getPrice())+".00");
           binding.buybtnid.setOnClickListener(view -> {
                if (user != null) {
                    if(user.getCart().AddToCart(id, user.getItems(),quant)){
                        Toast.makeText(this, user.getItems().get(id-1).getItemName()+" added to cart", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Item sold out", Toast.LENGTH_SHORT).show();
                    }


               }
          });
            binding.rentbtnid.setOnClickListener(view -> {
                if (user != null) {
                    if(user.getCart().AddToCart(id, user.getItems(),quant)){
                        Toast.makeText(this, user.getItems().get(id-1).getItemName()+" added to cart", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Item sold out", Toast.LENGTH_SHORT).show();
                    }


                }
            });
           binding.buttonDecrease.setOnClickListener(view -> {
               if(quant>1)
                   binding.itemQuantity1.setText(--quant+ "");
               binding.totalItemPrice.setText("$"+quant*Integer.parseInt(user.getItems().get(id-1).getPrice())+".00");
           });
            binding.buttonIncrease.setOnClickListener(view -> {
                if(quant < user.getItems().get(id-1).getQuantity()){
                    binding.itemQuantity1.setText(++quant+"");
                    binding.totalItemPrice.setText("$"+quant*Integer.parseInt(user.getItems().get(id-1).getPrice())+".00");
                }
            });
//
//            binding.totalItemPrice.setText(getQuantity());

        }
    }

    private int getQuantity() {
        return Integer.parseInt(binding.itemQuantity1.getText().toString());
    }
    private int Dec(){
        if(quant>1)
        return --quant;
        else return 1;

    }
    private int Inc(){
        if(quant < user.getItems().get(id-1).getQuantity()){
            return ++quant;
        }
        else {
            return user.getItems().get(id-1).getQuantity();
        }

    }


}