package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository {
    List<Product> searchByName(String name);

    List<Product> findAll();

    void deleteByName(String name);
}
