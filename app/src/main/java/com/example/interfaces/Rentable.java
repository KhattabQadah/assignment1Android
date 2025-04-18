package com.example.interfaces;

import com.example.classes.Cart;

public interface Rentable {
    public double RentPrice();
    public boolean isAvailable();
    public boolean addToRentCart(Cart cart);

    public boolean Rent();
}
