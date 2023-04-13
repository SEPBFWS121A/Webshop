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
    double price;

    public Product(int id, String image, String name, String description, String type, String theme, double price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.type = type;
        this.theme = theme;
        this.price = price;
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

    public double getPrice() {
        return price;
    }


}
