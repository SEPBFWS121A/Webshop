package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Cart;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.awt.*;
import java.util.List;

public class OrderOverview extends VerticalLayout {

    private H3 overview = new H3("Bestellübersicht");

    private Label orderValue = new Label();

    public OrderOverview (List<Cart> cart) {
        Calculator.calculatePrice(cart);
        orderValue.add("Bestellwert (" + Calculator.calculateAmount(cart) + ") Artikel " + Calculator.calculatePrice(cart));
        add(overview, orderValue);
    }

}
