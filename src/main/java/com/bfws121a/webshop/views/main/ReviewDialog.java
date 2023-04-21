package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Review;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import java.time.LocalDate;


public class ReviewDialog extends Dialog {
    FormLayout formLayout = new FormLayout();
    public ReviewDialog(ProductView productView, int productId) {

        Label publisherLabel = new Label("Name");
        Label descriptionLabel = new Label("Beschreibung");
        Label titleLabel = new Label("Titel");
        Label ratingLabel = new Label("Weiterempfehlung");

        TextField publisher = new TextField();
        TextField description = new TextField();
        TextField title = new TextField();

        Checkbox ratingCheckbox = new Checkbox();

        Button submitButton = new Button("Absenden", event -> {
            new Review(productId, publisher.getValue(), ratingCheckbox.getValue(), LocalDate.now().toString(), title.getValue(), description.getValue());
            productView.addReviews();
    });


        formLayout.add( publisherLabel, publisher, titleLabel, title, descriptionLabel, description, ratingLabel, ratingCheckbox, submitButton);
        add(formLayout);

    }

    //public Review(int productId, String publisher, boolean rating, String date, String title, String description)






}
