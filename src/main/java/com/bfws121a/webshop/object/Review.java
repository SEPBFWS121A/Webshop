package com.bfws121a.webshop.object;

import java.util.Date;

public class Review {

    int productId;
    String publisher;
    boolean rating;
    String date;
    String title;
    String description;

    public Review(int productId, String publisher, boolean rating, String date, String title, String description) {
        this.productId = productId;
        this.publisher = publisher;
        this.rating = rating;
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public String getPublisher() {
        return publisher;
    }

    public boolean getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
