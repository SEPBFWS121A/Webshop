package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.formlayout.FormLayout;
import java.util.List;


public class Catalog extends FormLayout {

    public Catalog (List<Product> products) {

        ProductTile prodTile = null;

        for (Product product : products) {
            prodTile = new ProductTile(product);
            prodTile.addClassNames("prodTile", product.getName());
            add(prodTile);
        }
    }
}
