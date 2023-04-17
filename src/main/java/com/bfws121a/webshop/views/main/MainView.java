package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.object.Review;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Main")
@Route(value = "", layout = Layout.class)
public class MainView extends VerticalLayout {

    private Button navigate;

    WholeReview reviews = new WholeReview();

    List<Product> prodList = new ArrayList<>();

    public MainView() {
        /*navigate = new Button("Katalog öffnen");
        navigate.addClickListener(e -> {
            UI.getCurrent().navigate("Katalog");
        });
        navigate.addClickShortcut(Key.ENTER);
        add(navigate)*/

        //setMargin(true);
        //setVerticalComponentAlignment(Alignment.END, navigate);
        Paragraph motto = new Paragraph("Erwecke deine Lego-Träume zum Leben!");
        motto.addClassName("motto");
        Div mottoDiv = new Div();
        mottoDiv.addClassName("mottoDiv");
        Image logo = new Image("icons/Logo.png","Logo");
        logo.getStyle().set("width","25%");
        Paragraph name = new Paragraph("Thomas' Klemmbaustein-Palast");
        name.getStyle().set("font-size","xx-large");
        name.getStyle().set("font-weight","bold");
        mottoDiv.add(name,logo,motto);
        for (Review review : reviews.getReviews(0)) {
            ReviewTile reviewTile = new ReviewTile(review);
            reviewTile.addClassName("reviews-prodPage");
            reviewTile.addClassName("reviewTile-prodPage");
            reviewTile.setWidth(50, Unit.PERCENTAGE);
            reviewTile.getStyle().set("margin","0 auto");
            reviewTile.getStyle().set("background-color","AliceBlue");
            reviewTile.getStyle().set("border-color","black");
            mottoDiv.add(reviewTile);
        }
        Paragraph highlightsTitle = new Paragraph("Unsere Highlights:");
        highlightsTitle.getStyle().set("font-size","x-large");
        highlightsTitle.getStyle().set("font-weight","bold");
        mottoDiv.add(highlightsTitle);
        prodList.add(new Product(12345, "icons/Ritterburg.png", "Ritterburg", "Egal", "Set", "Mittelalter",229.99));
        prodList.add(new Product(12346, "icons/Hogwards.png", "Hogwards", "Egal","Set", "Harry Potter", 499.99));
        prodList.add(new Product(12347, "icons/Bruchtal.png", "Bruchtal", "Egal","Set", "Herr der Ringe", 499.99));
        SelectiveCatalog catalog = new SelectiveCatalog(prodList);
        catalog.getStyle().set("width","100%");
        mottoDiv.add(catalog);
        Paragraph newProdsTitle = new Paragraph("Neu bei uns:");
        newProdsTitle.getStyle().set("font-size","x-large");
        newProdsTitle.getStyle().set("font-weight","bold");
        SelectiveCatalog catalog2 = new SelectiveCatalog(prodList);
        mottoDiv.add(newProdsTitle,catalog2);
        add(mottoDiv);
    }

}
