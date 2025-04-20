package com.example.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable {
    public static final String INTENT_KEY = "myObjectKey";
    String name,password;
    Cart cart;
    ArrayList<ArrayList<Items>> previousOrders;
    public static HashMap<Integer,Items> improvedItemList;
    public void setItems(ArrayList<Items> items) {
        improvedItemList = new HashMap<>();
        this.items = items;
        for(int i = 0;i<items.size();i++){
        improvedItemList.put(items.get(i).getId(),items.get(i));
        }
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
    static public Items getItemById(int id){
        return improvedItemList.get(id);
    }
}
