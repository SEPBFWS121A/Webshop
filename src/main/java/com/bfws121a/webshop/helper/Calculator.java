package com.bfws121a.webshop.helper;

import com.bfws121a.webshop.object.Cart;
import java.util.List;

public class Calculator {

    private List<Cart> cart;

    public Calculator(List<Cart> cart) {
        this.cart = cart;
    }

    public double calculatePrice () {
        int price = 0;
        for (Cart value : cart) {
            price += (value.getProd().getPrice() * value.getAmount());
        }
        return price;
    }

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

    public double calculateFullPrice () {
        return calculatePrice() + 500;
    }


}
