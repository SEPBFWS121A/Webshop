package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findByName(String name);


    void save(Order order);
}
