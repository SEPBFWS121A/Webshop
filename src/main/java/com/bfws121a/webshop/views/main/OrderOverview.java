package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.helper.Calculator;
import com.bfws121a.webshop.object.Cart;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;

import java.util.List;

public class OrderOverview extends VerticalLayout {

    private H3 overview = new H3("Bestellübersicht");

    private final Label orderAmount = new Label();
    private final Label orderPrice = new Label();

    private final Label shipping = new Label("Versandkosten");

    private final Label shippingCosts = new Label("5.00 €");

    private final Label total = new Label("Gesamtsumme");

    private final Label totalPrice = new Label();

    private final List<Cart> cart;

    public OrderOverview (List<Cart> cart) {
        this.cart = cart;
        setLabels();
        HorizontalLayout first = new HorizontalLayout(orderAmount, orderPrice);
        first.setSizeFull();
        first.expand(orderAmount);
        HorizontalLayout second = new HorizontalLayout(shipping, shippingCosts);
        second.setSizeFull();
        second.expand(shipping);
        HorizontalLayout third = new HorizontalLayout(total, totalPrice);
        third.setSizeFull();
        third.expand(total);
        add(overview, first, second, third);
    }

    public void setLabels() {
        orderAmount.setText("Bestellwert (" + Calculator.calculateAmount() + ") Artikel ");
        orderPrice.setText(Calculator.calculatePrice() + " €");
        total.getStyle().set("font-weight", "bold");
        totalPrice.setText(Calculator.calculateFullPrice() + " €");
        totalPrice.getStyle().set("font-weight", "bold");
    }

}
