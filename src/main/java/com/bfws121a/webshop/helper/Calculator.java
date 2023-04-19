package com.bfws121a.webshop.helper;

import com.bfws121a.webshop.object.Cart;
import java.util.List;

public class Calculator {

    public static List<Cart> cart;

    public static double calculatePrice () {
        double price = 0;
        for (Cart value : cart) {
            price += (value.getProd().getPrice() * value.getAmount());
        }
        return price;
    }

    public static int calculateAmount () {
        int amount = 0;
        for (Cart value : cart) {
            amount += value.getAmount();
        }
        return amount;
    }

    public static double calculateFullPrice () {
        return calculatePrice() + 5;
    }

    public static void setCalcList (List<Cart> cartList) {
        cart = cartList;
    }

}
