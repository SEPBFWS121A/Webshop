package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.helper.Calculator;
import com.bfws121a.webshop.object.Cart;
import com.vaadin.flow.component.button.Button;
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

    private final Label vTA = new Label();

    private final Button buy = new Button("Kaufabwicklung");

    private final List<Cart> cart;

    private Calculator calculator;

    public OrderOverview (List<Cart> cart, Calculator calculator) {
        this.cart = cart;
        this.calculator = calculator;
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
        HorizontalLayout fourth = new HorizontalLayout(vTA);
        fourth.setSizeFull();
        fourth.expand(vTA);
        buy.addClassName("cart");
        buy.addClickListener(e -> {
            BuyDialog buy = new BuyDialog(cart);
            buy.open();
        });
        add(overview, first, second, third, fourth, buy);
    }

    public void setLabels() {
        if(calculator.calculateAmount() == 0) {
            removeFromParent();
        } else {
            orderAmount.setText("Bestellwert (" + calculator.calculateAmount() + ") Artikel ");
            orderPrice.setText(calculator.calculatePrice()  / 100 + " €");
            total.getStyle().set("font-weight", "bold");
            totalPrice.setText(calculator.calculateFullPrice() / 100 + " €");
            totalPrice.getStyle().set("font-weight", "bold");
            vTA.setText("Enthält MwSt. in Höhe von " + calculator.calculateVAT() / 100 + " €");
            vTA.getStyle().set("text-align", "end");
            vTA.getStyle().set("color", "#6e6e73");
        }
    }

}
