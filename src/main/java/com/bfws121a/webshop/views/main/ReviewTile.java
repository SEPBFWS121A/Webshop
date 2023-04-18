package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Review;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ReviewTile extends VerticalLayout {

    private Label publisher;
    private Label date;
    private Label rating;
    private Label title;
    private Label description;

    private Label divider;

    public ReviewTile(Review review) {
        this.setSpacing(false);

        publisher = new Label(review.getPublisher());
        publisher.addClassName("publisher-reviewTile");
        date = new Label(String.valueOf(review.getDate()));
        date.addClassName("date-reviewTile");
        title = new Label(review.getTitle());
        title.addClassName("title-reviewTile");
        description = new Label(review.getDescription());
        description.addClassName("description-reviewTile");

        divider = new Label();
        divider.getElement().setProperty("innerHTML", "<hr />");
        divider.addClassName("divider-reviewTile");

        if (review.getRating()) {
            rating = new Label("Würden Sie das Produkt weiterempfehlen? Ja");
            rating.getStyle().set("color", "green");
        } else if(!review.isShop()) {
            rating = new Label("Würden Sie das Produkt weiterempfehlen? Nein");
            rating.getStyle().set("color", "red");
        } else {
            rating = new Label();
        }
        rating.addClassName("rating-reviewTile");

        add(publisher, date, title, description, divider, rating);

        this.getStyle().set("margin-top", "20px");
    }
}
