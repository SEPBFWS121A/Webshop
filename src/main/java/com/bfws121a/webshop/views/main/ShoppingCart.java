package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.helper.Calculator;
import com.bfws121a.webshop.object.Cart;
import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Einkaufswagen")
@Route(value = "Warenkorb", layout = Layout.class)
public class ShoppingCart extends VerticalLayout {

    final private static List<Cart> productList = new ArrayList<>();
    OrderOverview orderOverview;
    H2 headline;

    private Calculator calculator;

    public ShoppingCart () {

        if(productList.isEmpty()) {
            headline = new H2("Ihr Warenkorb ist leer");
            headline.addClassName("headline-shoppingcart");
            add(headline);
        } else {
            calculator = new Calculator(productList);
            headline = new H2("Mein Warenkorb");
            add(headline);
            VerticalLayout prods = new VerticalLayout();
            for (Cart product : productList) {
                CartProdTile cartProdTile = new CartProdTile(product);
                prods.add(cartProdTile);
                cartProdTile.addDeleteEventListener(this::removeProd);
                cartProdTile.addChangeEventListener(this::updateOrderOverview);
            }
            orderOverview = new OrderOverview(productList, calculator);
            orderOverview.getStyle().set("align-self", "flex-start");
            FormLayout both = new FormLayout(prods, orderOverview);
            add(both);
        }
    }

    public static void addToList(Product prod) {
        if(containsID(prod.getId())) {
            productList.stream().filter(e -> e.getProd().getId() == prod.getId()).findFirst().get().increaseAmount();
        } else {
            productList.add(new Cart(prod));
        }
    }

    private static boolean containsID(int id) {
        return productList.stream().anyMatch(e -> e.getProd().getId() == id);
    }

    private void removeProd(CartProdTile.DeleteCartEvent event) {
        productList.remove(event.getCart());
        if(productList.isEmpty()) {
            headline.setText("Ihr Warenkorb ist leer");
        }
            orderOverview.setLabels();
    }

    private void updateOrderOverview(CartProdTile.ChangeEvent event) {
        orderOverview.setLabels();
    }

}
