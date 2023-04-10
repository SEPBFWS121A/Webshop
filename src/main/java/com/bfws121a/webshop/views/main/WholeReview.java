package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Review;

import java.util.ArrayList;
import java.util.List;

public class WholeReview {

    List<Review> reviews = new ArrayList<>();

    public WholeReview() {
        reviews.add(new Review(12345, "Max Mustermann", true, "08.04.2023",
                "Tolles Produkt", "Tolles Produkt, gerne wieder!"));
        reviews.add(new Review(12345, "Maria Musterfrau", true, "09.04.2023",
                "Tolles Produkt", "Tolles Produkt, gerne wieder!"));
        reviews.add(new Review(12346, "Max Mustermann", false, "07.04.2023",
                "Toller Laden, schlechtes Produkt", "Toller Laden, nur das Produkt ist nicht so toll, dennoch gerne wieder!"));
    }

    public List<Review> getReviews(int id) {
        List<Review> productReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getProductId() == id) {
                productReviews.add(review);
            }
        }
        return productReviews;
    }

}
