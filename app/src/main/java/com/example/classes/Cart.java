package com.example.classes;

import java.util.ArrayList;

public class Cart {
    private boolean flag;

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
    public boolean AddToCart(int itemID,ArrayList<Items> items,int quant){
        flag=false;
       for(int i =0;i<items.size();i++){
           if(items.get(i).getItemID()==itemID){
               if(items.get(i).getQuantity()<=0){
                   return false;
               }
               if(checkIfExistsAndToQuantity(itemID,items,quant)){
                    return true;
               }
               else{
                   if(!flag){
                       Items item = new Items(items.get(i),quant);
                       cart.add(item);
                       flag=false;
                       return true;

                   }

               }

           }
       }
       return false;
    }
    public boolean checkIfExistsAndToQuantity(int itemID,ArrayList<Items> items,int quant){
        if(!cart.isEmpty()){
            for(int i = 0;i<cart.size();i++){
                if(cart.get(i).getId()==itemID){
                    if(quant>User.getItemById(itemID).getQuantity()||(quant+cart.get(i).getQuantity())>User.getItemById(itemID).getQuantity()){
                        flag = true;
                        return false;
                    }
                    cart.get(i).setQuantity(cart.get(i).getQuantity()+quant);
                    return true;
                }
            }
        }
        else{
            return false;
        }
        return false;
    }

}
