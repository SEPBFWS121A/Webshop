package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route(value = "product")
public class ProductView extends HorizontalLayout implements HasUrlParameter<Integer> {

    Product product;
    WholeCatalog catalog = new WholeCatalog();

    final private Button shoppingCart = new Button("In den Warenkorb", new Icon(VaadinIcon.CART));

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer id) {

        for (Product product : catalog.getCatalog()) {
            if (id == product.getId()) {
                this.product = product;
            }
        }

        // Product image
        Image productImage = new Image(product.getImage(), product.getName());
        productImage.addClassName("image-prodPage");

        // Product name
        Label productName = new Label(product.getName());
        productName.addClassName("nameLabel-prodPage");

        // Product price label
        Label productPrice = new Label(String.valueOf(product.getPrice()) + " €");
        productPrice.addClassName("priceLabel-prodPage");
        shoppingCart.addClassName("cart-productPage");

        // Divider
        Label divider1 = new Label();
        divider1.getElement().setProperty("innerHTML", "<hr />");
        divider1.addClassName("divider1-prodPage");

        // Description title label
        Label descriptionTitle = new Label("Beschreibung");
        descriptionTitle.addClassName("descriptionTitle-prodPage");

        // Description label
        Label productDescription = new Label();
        productDescription.getElement().setProperty("innerHTML", product.getDescription());
        productDescription.addClassName("description-prodPage");

        // Divider
        Label divider2 = new Label();
        divider2.getElement().setProperty("innerHTML", "<hr />");
        divider2.addClassName("divider2-prodPage");

        // Reviews title label
        Label reviewsTitle = new Label("Bewertungen");
        reviewsTitle.addClassName("reviewsTitle-prodPage");

        // Reviews  label
        Label review = new Label("Zu diesem Produkt existieren leider noch keine Bewertungen.");
        reviewsTitle.addClassName("reviews-prodPage");

        add(productImage, productName, productPrice, shoppingCart, divider1, descriptionTitle,
                productDescription, divider2, reviewsTitle);

        this.setClassName("grid-product");
        this.setSizeFull();
    }
}
