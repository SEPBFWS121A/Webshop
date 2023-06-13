package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Review;
import com.bfws121a.webshop.repositories.H2ReviewRepository;
import com.bfws121a.webshop.services.ReviewService;

import java.util.ArrayList;
import java.util.List;

public class WholeReview {

    ReviewService reviewService;
    List<Review> reviews;

    public WholeReview() {
        reviewService = new ReviewService(new H2ReviewRepository(System.getenv("FHDW_WEBSHOP_DB_URL"), System.getenv("FHDW_WEBSHOP_DB_USER"), System.getenv("FHDW_WEBSHOP_DB_PASSWORD")));
        reviews = reviewService.findAll();

        reviews.forEach(e -> System.out.println("HEY: " + e));
    }

    public void addReview(Review review) {
        reviewService.save(review);
        reviews = reviewService.findAll();
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
