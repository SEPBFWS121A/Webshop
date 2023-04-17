package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ProductTile extends VerticalLayout {

    private Image productImage;
    private Label productName;
    private Label productPrice;
    final private Button shoppingCart = new Button("In den Warenkorb", new Icon(VaadinIcon.CART));

    public ProductTile(Product pro) {
        productImage = new Image(pro.getImage(), pro.getName());
        productImage.addClassName("image-prodTile");
        productName = new Label(pro.getName());
        productName.addClassName("label-prodTile");
        productPrice = new Label(String.valueOf(pro.getPrice()));
        productPrice.addClassName("label-prodTile");
        shoppingCart.addClassName("cart");
        add(productImage, productName, productPrice, shoppingCart);
        this.getStyle().set("margin-right", "10px");

        // navigate to selected product
        productImage.addClickListener(e -> this.getUI().ifPresent(ui -> ui.navigate("product/" + pro.getId())));
        productImage.getStyle().set("cursor", "pointer");

    }

}
