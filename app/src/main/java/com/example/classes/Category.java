package com.example.classes;

import java.util.ArrayList;

public class Category {

    User user;
    private String name;
    private ArrayList<Items> items;

    public Category() {
    }
    public Category(String name, ArrayList<Items> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
