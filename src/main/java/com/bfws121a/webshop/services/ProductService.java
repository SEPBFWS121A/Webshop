package com.bfws121a.webshop.services;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProductService {
    ProductRepository repo;
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> searchByName(String name) {
        return repo.searchByName(name);
    }

    public List<Product> searchByProductTag(String productTag) {
        return repo.searchByProductTag(productTag);
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public void deleteByName(String name) {
        repo.deleteByName(name);
    }
}
