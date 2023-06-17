package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Review;

import java.util.List;

public interface ReviewRepository {
    List<Review> findByProdId(int prodId);

    List<Review> findAll();

    void saveReview(Review review);

    void deleteByName(String name, int id);
}
