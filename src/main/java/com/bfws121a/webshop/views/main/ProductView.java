package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route(value = "product")
public class ProductView extends Div implements HasUrlParameter<Integer> {

    Product product;
    Catalog catalog = new Catalog();

    final private com.vaadin.flow.component.button.Button shoppingCart = new Button("In den Warenkorb", new Icon(VaadinIcon.CART));

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer id) {

        for (Product product : catalog.getCatalog()) {
            if (id == product.getId()) {
                this.product = product;
            }
        }

        if (product != null) {
            Image productImage = new Image(product.getImage(), product.getName());
            productImage.addClassName("image-prodPage");
            Label productName = new Label(product.getName());
            productName.addClassName("label-prodPage");
            Label productPrice = new Label(String.valueOf(product.getPrice()));
            productPrice.addClassName("label-prodPage");
            shoppingCart.addClassName("cart");
            add(productImage, productName, productPrice, shoppingCart);
            this.setSizeFull();
        } else {
            setText("Could not find product");
        }
    }
}
