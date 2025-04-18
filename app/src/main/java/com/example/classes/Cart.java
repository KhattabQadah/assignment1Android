package com.example.classes;

import java.util.ArrayList;

public class Cart {
    public ArrayList<Items> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Items> cart) {
        this.cart = cart;
    }

    public ArrayList<Items> cart;
    public Cart(User user){
        cart = new ArrayList<Items>();
    }
    public boolean AddToCart(int itemID,ArrayList<Items> items){
       for(int i =0;i<items.size();i++){
           if(items.get(i).getItemID()==itemID){
               if(items.get(i).getQuantity()<=0){
                   return false;
               }
               cart.add(items.get(i));
               return true;
           }
       }
       return false;
    }

}
