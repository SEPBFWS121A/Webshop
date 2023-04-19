package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Cart;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class OrderOverview extends VerticalLayout {

    private H3 overview = new H3("Bestellübersicht");

    private final Label orderValue = new Label();

    private final List<Cart> cart;

    public OrderOverview (List<Cart> cart) {
        this.cart = cart;
        Calculator.calculatePrice(cart);
        setLabel();
        add(overview, orderValue);
    }

    public void setLabel() {
        orderValue.setText("Bestellwert (" + Calculator.calculateAmount(cart) + ") Artikel " + Calculator.calculatePrice(cart));
    }

}
