package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Cart;
import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "Warenkorb", layout = Layout.class)
public class ShoppingCart extends VerticalLayout {

    final private static List<Cart> productList = new ArrayList<>();
    OrderOverview orderOverview;

    public ShoppingCart () {
        H2 headline = new H2("Mein Warenkorb");
        add(headline);
        for (Cart product : productList) {
            CartProdTile cartProdTile = new CartProdTile(product);
            add(cartProdTile);
            cartProdTile.addDeleteEventListener(this::removeProd);
            cartProdTile.addChangeEventListener(this::updateOrderOverview);
        }
        orderOverview = new OrderOverview(productList);
        add(orderOverview);
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
        orderOverview.setLabel();
    }

    private void updateOrderOverview(CartProdTile.ChangeEvent event) {
        orderOverview.setLabel();
    }

}
