package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.List;


public class SelectiveCatalog extends HorizontalLayout {

    public SelectiveCatalog(List<Product> products) {

        for (Product product : products) {
             MainProductTile prodTile = new MainProductTile(product);
            prodTile.addClassName("test");
            prodTile.getStyle().set("width","33.33%");
            prodTile.getStyle().set("margin","0 5px");
            add(prodTile);
        }

    }
}
