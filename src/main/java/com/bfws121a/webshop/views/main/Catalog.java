package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "Test")
public class Catalog extends HorizontalLayout {

    List<Product> prodList = new ArrayList<>();

    public Catalog () {
        prodList.add(new Product("icons/Ritterburg.png", "Ritterburg", "Egal", 229.99));
        prodList.add(new Product("icons/Hogwards.png", "Hogwards", "Egal", 499.99));
        prodList.add(new Product("icons/Bruchtal.png", "Bruchtal", "Egal", 499.99));

        for (Product product : prodList) {
            ProductTile prodTile = new ProductTile(product);
            prodTile.addClassName("test");
            add(prodTile);
            this.setAlignItems(Alignment.END);
        }
    }
}
