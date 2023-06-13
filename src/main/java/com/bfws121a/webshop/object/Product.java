package com.bfws121a.webshop.object;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Span;


public class Product {

    int id;
    String image;
    String name;
    String description;
    String type;
    String theme;
    String priceCate;
    int price;

    String producttags;


    public Product(int id, String image, String name, String description, String type, String theme, int price, String producttags) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.type = type;
        this.theme = theme;
        this.price = price;
        this.producttags = producttags;
        setPriceCate(price);
    }

    private void setPriceCate (double price){
        if(price <= 2000) {
            priceCate = "0€ - 20€";
        } else if (price > 2000 && price <= 5000) {
            priceCate = "20€ - 50€";
        } else if (price > 5000 && price <= 10000) {
            priceCate = "50€ - 100€";
        } else if (price > 10000 && price <= 20000) {
            priceCate = "100€ - 200€";
        } else {
            priceCate = "200€+";
        }
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getTheme() {
        return theme;
    }

    //Fehlt noch UNIT Test
    public String getPriceCate () {
        return priceCate;
    }

    public double getPrice() {
        return price;
    }

    public String getProducttags() {
        return producttags;
    }

    @Override
    public String toString() {
        return id + " / " + image + " / " + name + " / " + description + " / "  + type + " / " + priceCate + " / " + getPrice();
    }



}
