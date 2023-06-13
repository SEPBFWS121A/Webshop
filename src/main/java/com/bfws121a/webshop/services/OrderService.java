package com.bfws121a.webshop.services;

import com.bfws121a.webshop.object.Order;
import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.repositories.OrderRepository;
import com.bfws121a.webshop.repositories.ProductRepository;

import java.util.List;

public class OrderService {
    OrderRepository repo;
    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> orderFindByName(String name) {
        return repo.findByName(name);
    }


    public void save(Order order) {
        repo.save(order);
    }
}
