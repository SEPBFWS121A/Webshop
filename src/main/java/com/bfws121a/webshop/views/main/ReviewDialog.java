package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Review;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ReviewDialog extends Dialog {

    Review review;
    FormLayout formLayout = new FormLayout();
    public ReviewDialog(ProductView productView, int productId) {

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 2));

        Label publisherLabel = new Label("Name");
        TextField publisher = new TextField();

        Label titleLabel = new Label("Titel");
        TextField title = new TextField();

        Label descriptionLabel = new Label("Beschreibung");
        TextArea description = new TextArea();
        description.addClassName("reviewDialog-description");

        Label ratingLabel = new Label("Weiterempfehlung");
        Checkbox ratingCheckbox = new Checkbox();

        Button cancelButton = new Button("Abbrechen", event -> this.close());

        Button submitButton = new Button("Absenden", event -> {
            review = new Review(productId, publisher.getValue(), ratingCheckbox.getValue(), LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString(), title.getValue(), description.getValue(), productId);
            productView.appendReviews(review);
            productView.addReviews();
            this.close();
    });


        formLayout.add(publisherLabel, publisher, titleLabel, title, descriptionLabel, description, ratingLabel, ratingCheckbox, cancelButton, submitButton);

        formLayout.setColspan(publisherLabel, 2);
        formLayout.setColspan(publisher, 2);
        formLayout.setColspan(titleLabel, 2);
        formLayout.setColspan(title, 2);
        formLayout.setColspan(descriptionLabel, 2);
        formLayout.setColspan(description, 2);

        add(formLayout);

    }

}
