package com.bfws121a.webshop.services;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.object.Review;
import com.bfws121a.webshop.repositories.ProductRepository;
import com.bfws121a.webshop.repositories.ReviewRepository;

import java.util.List;

public class ReviewService {

    ReviewRepository repository;
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> findAll() {
        return repository.findAll();
    }

    public List<Review> findByProdId(int prodId) {
        return repository.findByProdId(prodId);

    }

    public void save(Review review) {
        repository.saveReview(review);
    }
}
