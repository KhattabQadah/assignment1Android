package com.example.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    public static final String INTENT_KEY = "myObjectKey";
    String name,password;
    Cart cart;
    ArrayList<ArrayList<Items>> previousOrders;

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    ArrayList<Items> items;
    public User(String password, String name) {
        this.cart = new Cart(this);
        this.password = password;
        this.name = name;
        previousOrders=new ArrayList<ArrayList<Items>>();
    }
    public void saveorder(){

        previousOrders.add(cart.cart);
        cart.cart.clear();
    }

    public User() {
        this.cart= new Cart(this);
    }

    public Cart getCart() {
        return cart;
    }
}
