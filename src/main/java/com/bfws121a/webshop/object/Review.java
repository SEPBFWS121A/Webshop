package com.bfws121a.webshop.object;

import java.util.Date;

public class Review {


    int reviewID;
    String publisher;
    boolean rating;
    String date;
    String title;
    String description;
    int productId;

    Boolean shopReview = false;

    public Review(int reviewID, String publisher, boolean rating, String date, String title, String description, int productId) {
        this.reviewID = reviewID;
        if(this.productId == 0) this.shopReview = true;
        this.publisher = publisher;
        this.rating = rating;
        this.date = date;
        this.title = title;
        this.description = description;
        this.productId = productId;
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

    public boolean isShop() { return shopReview;}
}
