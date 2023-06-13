package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ProductTile extends VerticalLayout {

    Product pro;
    private Image productImage;
    private Label productName;
    private Label productPrice;
    final private Button shoppingCart = new Button("In den Warenkorb", new Icon(VaadinIcon.CART));

    public ProductTile(Product pro) {
        this.pro = pro;
        productImage = new Image(pro.getImage(), pro.getName());
        productImage.addClassName("image-prodTile");
        productName = new Label(pro.getName());
        productName.addClassName("label-prodTile");
        productName.setId("label-" + pro.getName());
        productPrice = new Label(pro.getPrice() / 100 + " €");
        productPrice.addClassName("label-prodTile");
        shoppingCart.addClassName("cart");
        shoppingCart.addClickListener(e -> {
            System.out.println("TEST");
            ShoppingCart.addToList(pro);
            AddCartDialog cartDialog = new AddCartDialog(pro);
            cartDialog.open();
        });

        add(productImage, productName, productPrice, shoppingCart);
        this.getStyle().set("margin-right", "10px");

        // navigate to selected product
        productImage.addClickListener(e -> this.getUI().ifPresent(ui -> ui.navigate("product/" + pro.getId())));
        productImage.getStyle().set("cursor", "pointer");
        this.setId("ProductTile-" + pro.getName());
    }

    public Product returnProd() {
        return pro;
    }


}
