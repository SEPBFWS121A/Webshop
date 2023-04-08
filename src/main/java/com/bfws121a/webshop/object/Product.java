package com.bfws121a.webshop.object;

public class Product {

    int id;
    String image;
    String name;
    String description;
    double price;

    public Product(int id, String image, String name, String description, double price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
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

    public double getPrice() {
        return price;
    }
}
