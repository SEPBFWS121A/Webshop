package com.bfws121a.webshop.object;

public class Cart {

    private Product prod;

    private int amount;

    public Cart(Product prod) {
        this.prod = prod;
        amount = 1;
    }

    public Product getProd() {
        return prod;
    }

    public int getAmount() {
        return amount;
    }

    public void increaseAmount() {
        amount++;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
