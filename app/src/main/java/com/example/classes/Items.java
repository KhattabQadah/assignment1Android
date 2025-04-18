package com.example.classes;

import com.example.interfaces.Rentable;

import java.util.ArrayList;

public class Items implements Rentable {




    private static int itemsID;

    public int getId() {
        return id;
    }

    private int id;
    public Items(String itemName, String price, int images) {
        ItemName = itemName;
        this.price = price;
        this.images = images;
        itemsID++;
        this.id=itemsID;
        quantity= (int) ((Math.random() * 20) + 1);;
    }
    public boolean buyItem(){
        if(quantity>0){
            quantity--;
            return true;
        }
        else return false;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTimesSold() {
        return timesSold;
    }

    public void setTimesSold(int timesSold) {
        this.timesSold = timesSold;
    }

    private int rentPrice;
    private int timesSold;
    private String ItemName;
    private String price;
    private int images;

    private Category category;
    private int quantity = 0;
    private boolean isAvailable = true;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean isAvailable() {
        if(quantity>0&&isAvailable){

            return true;
        }
        else return false;
    }

    @Override
    public boolean addToRentCart(Cart cart) {

        return true;
    }

    @Override
    public double RentPrice() {
        return rentPrice;
    }




    @Override
    public boolean Rent() {
        return false;
    }

    public boolean addToCart(ArrayList<Items> cart) {
        if(isAvailable) {
            cart.add(this);
            return true;
        }
        else return false;
    }
    public int getItemID() {
        return id;
    }
}
