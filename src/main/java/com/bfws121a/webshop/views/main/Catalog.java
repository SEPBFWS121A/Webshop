package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;


public class Catalog extends FormLayout {



    public Catalog (List<Product> products) {

        for (Product product : products) {
            ProductTile prodTile = new ProductTile(product);
            prodTile.addClassName("test");
            add(prodTile);
        }

    }

    public List<Product> getCatalog() {
        return prodList;
    }

    public List<Product> getCatalog() {
        return prodList;
    }
}
