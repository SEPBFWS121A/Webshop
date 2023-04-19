package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Cart;
import java.util.List;

public class Calculator {

    public static double calculatePrice (List<Cart> cart) {
        double price = 0;
        for (Cart value : cart) {
            price += (value.getProd().getPrice() * value.getAmount());
        }
        return price;
    }

    public static int calculateAmount (List<Cart> cart) {
        int amount = 0;
        for (Cart value : cart) {
            amount += value.getAmount();
        }
        return amount;
    }

}
