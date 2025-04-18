package com.example.two_activities_app;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classes.ListAdapter;
import com.example.classes.User;
import com.example.classes.Cart;
import com.example.classes.UserManager;
import com.example.two_activities_app.databinding.CartViewBinding; // adjust package as needed
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CartActivity extends AppCompatActivity {

    CartViewBinding binding;
    ListAdapter adapter;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CartViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         user = UserManager.getUser();
        adapter = new ListAdapter(CartActivity.this,user.getCart().cart,user);
        binding.listview2.setAdapter(adapter);
        FloatingActionButton fabCheckout = binding.checkout;
        fabCheckout.setOnClickListener(view -> {
            for(int i=0;i<user.getCart().cart.size();i++){
                user.getCart().cart.get(i).buyItem();
            }
            user.saveorder();
            adapter = new ListAdapter(CartActivity.this,user.getCart().cart,user);
            binding.listview2.setAdapter(adapter);
            Toast.makeText(this, "Checkout clicked!", Toast.LENGTH_SHORT).show();


        });

    }

}