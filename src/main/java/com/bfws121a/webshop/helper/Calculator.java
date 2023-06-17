package com.bfws121a.webshop.helper;

import com.bfws121a.webshop.object.Cart;
import java.util.List;

public class Calculator {

    private List<Cart> cart;

    public Calculator(List<Cart> cart) {
        this.cart = cart;
    }


    //fehlt noch UNIT Test
    public double calculatePrice () {
        int price = 0;
        for (Cart value : cart) {
            price += (value.getProd().getPrice() * value.getAmount());
        }
        return price;
    }

    //TEST VON ROBIN
    public int calculateAmount () {
        int amount = 0;
        for (Cart value : cart) {
            amount += value.getAmount();
        }
        return amount;
    }

    public double calculateVAT () {
        double amount = calculateFullPrice() / 119;
        amount *= 19;
        return Math.round(amount);
    }

    public double calculateShippingCosts() {
        if (calculatePrice() >= 50000) return 0;
        if (calculatePrice() >= 25000) return 250;
        return 500;
    }

    public double calculateFullPrice () {
        return calculatePrice() + calculateShippingCosts();
    }


}
