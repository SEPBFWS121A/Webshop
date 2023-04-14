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
    double price;


    public Product(int id, String image, String name, String description, String type, String theme, double price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.type = type;
        this.theme = theme;
        this.price = price;
        setPriceCate(price);
    }

    private void setPriceCate (double price){
        if(price <= 20) {
            priceCate = "0€ - 20€";
        } else if (price > 20 && price <= 50) {
            priceCate = "20€ - 50€";
        } else if (price > 50 && price <= 100) {
            priceCate = "50€ - 100€";
        } else if (price > 100 && price <= 200) {
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

    public String getPriceCate () {
        return priceCate;
    }

    public double getPrice() {
        return price;
    }


}
