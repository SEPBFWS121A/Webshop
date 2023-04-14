package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.object.Review;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "product", layout = Layout.class)
public class ProductView extends FormLayout implements HasUrlParameter<Integer> {

    FormLayout productInfo = new FormLayout();
    FormLayout productOverview = new FormLayout();
    Product product;
    WholeCatalog catalog = new WholeCatalog();
    WholeReview reviews = new WholeReview();

    final private Button shoppingCart = new Button("In den Warenkorb", new Icon(VaadinIcon.CART));

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer id) {

        // FormLayout responsiveness
        this.setResponsiveSteps(
                new ResponsiveStep("0", 1)
        );
        productInfo.setResponsiveSteps(
                // always use one column
                new ResponsiveStep("0", 1)
        );
        productOverview.setResponsiveSteps(
                // Mobile first: use one column
                new ResponsiveStep("0", 1),
                // Desktop view: use two columns
                new ResponsiveStep("800px", 2)
        );

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

        // ID label
        Label productId = new Label("Artikelnummer: " + String.valueOf(product.getId()));
        productId.addClassName("idLabel-prodPage");

        // Product price label
        Label productPrice = new Label(String.valueOf(product.getPrice()) + " €");
        productPrice.addClassName("priceLabel-prodPage");

        // Shoppint cart button
        shoppingCart.addClassName("cart-productPage");

        // Divider
        Hr divider1 = new Hr();
        divider1.addClassName("divider1-prodPage");
        divider1.setWidth(70, Unit.PERCENTAGE);

        // Description title label
        Label descriptionTitle = new Label("Beschreibung");
        descriptionTitle.addClassName("descriptionTitle-prodPage");
        descriptionTitle.setWidth(70, Unit.PERCENTAGE);

        // Description label
        Label productDescription = new Label();
        productDescription.getElement().setProperty("innerHTML", product.getDescription());
        productDescription.addClassName("description-prodPage");
        productDescription.setWidth(70, Unit.PERCENTAGE);

        // Divider
        Hr divider2 = new Hr();
        divider2.addClassName("divider2-prodPage");
        divider2.setWidth(70, Unit.PERCENTAGE);

        // Reviews title label
        Label reviewsTitle = new Label("Bewertungen");
        reviewsTitle.addClassName("reviewsTitle-prodPage");
        reviewsTitle.setWidth(70, Unit.PERCENTAGE);

        // Vertical layout for name, id, price and checkout button
        productInfo.add(productName, productId, productPrice, shoppingCart);

        // Add image and vLayout to hLayout
        productOverview.add(productImage, productInfo);

        // Add hLayout and rest to main layout
        add(productOverview, descriptionTitle, productDescription, divider2, reviewsTitle);

        // Reviews
        for (Review review : reviews.getReviews(product.getId())) {
            if (reviews.getReviews(product.getId()).size() > 0) {
                ReviewTile reviewTile = new ReviewTile(review);
                reviewTile.addClassName("reviews-prodPage");
                reviewTile.addClassName("reviewTile-prodPage");
                reviewTile.setWidth(70, Unit.PERCENTAGE);
                add(reviewTile);
            } else {
                Label reviewText = new Label("Zu diesem Produkt existieren leider noch keine Bewertungen.");
                reviewText.addClassName("reviews-prodPage");
                reviewText.setWidth(70, Unit.PERCENTAGE);
                add(reviewText);
            }
        }

        // add footer
        add(new Footer());

        //this.verticalLayout.setClassName("grid-product");
        productInfo.setSizeFull();
        productOverview.setSizeFull();
        this.setSizeFull();
    }
}
