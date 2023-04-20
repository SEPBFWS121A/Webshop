package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.object.Review;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.ShortcutRegistration;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BrowserWindowResizeListener;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Main")
@Route(value = "", layout = Layout.class)
public class MainView extends FormLayout {

    private Button navigate;

    WholeReview reviews = new WholeReview();

    List<Product> prodList = new ArrayList<>();

    HorizontalLayout layout = new HorizontalLayout();
    HorizontalLayout leftLayout = new HorizontalLayout();
    Div nameLayout = new Div();
    Div leftDiv = new Div();
    Div rightDiv = new Div();
    HorizontalLayout highlightProducts = new HorizontalLayout();
    HorizontalLayout newProducts = new HorizontalLayout();
    int pageWidth = 0;

    public MainView() {

        this.getStyle().set("margin", "15px");

        // responsiveness
        this.setResponsiveSteps(
                // mobile first
                new ResponsiveStep("0", 1),
                // desktop
                new ResponsiveStep("1050px", 4)
        );

        leftDiv.addClassName("mainDiv");

        Image logo = new Image("icons/Logo.png","Logo");
        logo.getStyle().set("height","15%");
        logo.getStyle().set("width","20%");

        nameLayout.getStyle().set("text-align","center");
        nameLayout.getStyle().set("width","100%");
        Paragraph motto = new Paragraph("Erwecke deine Lego-Träume zum Leben!");
        motto.addClassName("motto");

        Paragraph name = new Paragraph("Thomas' Klemmbaustein-Palast");
        name.getStyle().set("font-size","xx-large");
        name.getStyle().set("font-weight","bold");

        nameLayout.add(name,motto);

        leftLayout.add(logo,nameLayout);
        leftDiv.add(leftLayout);

        Paragraph highlightsTitle = new Paragraph("Unsere Highlights:");
        highlightsTitle.getStyle().set("font-size","x-large");
        highlightsTitle.getStyle().set("font-weight","bold");
        leftDiv.add(highlightsTitle);

        prodList.add(new Product(12345, "icons/Ritterburg.png", "Ritterburg", "Egal", "Set", "Mittelalter",229.99));
        prodList.add(new Product(12346, "icons/Hogwards.png", "Hogwards", "Egal","Set", "Harry Potter", 499.99));
        prodList.add(new Product(12347, "icons/Bruchtal.png", "Bruchtal", "Egal","Set", "Herr der Ringe", 499.99));
        SelectiveCatalog catalog = new SelectiveCatalog(prodList);
        catalog.getStyle().set("width","100%");
        highlightProducts.add(catalog);
        highlightProducts.getStyle().set("overflow", "auto");
        highlightProducts.getStyle().set("display", "block");
        leftDiv.add(highlightProducts);

        Paragraph newProdsTitle = new Paragraph("Neu bei uns:");
        newProdsTitle.getStyle().set("font-size","x-large");
        newProdsTitle.getStyle().set("font-weight","bold");
        SelectiveCatalog catalog2 = new SelectiveCatalog(prodList);

        newProducts.add(catalog2);
        newProducts.getStyle().set("overflow", "auto");
        newProducts.getStyle().set("display", "block");
        leftDiv.add(newProdsTitle,newProducts);

        rightDiv.addClassName("mainDiv");

        Paragraph reviewTitle = new Paragraph("Bewertungen:");
        reviewTitle.getStyle().set("font-size","x-large");
        reviewTitle.getStyle().set("font-weight","bold");
        rightDiv.add(reviewTitle);

        for (Review review : reviews.getReviews(0)) {
            ReviewTile reviewTile = new ReviewTile(review);
            reviewTile.addClassName("reviews-prodPage");
            reviewTile.addClassName("reviewTile-prodPage");
            reviewTile.setWidth(50, Unit.PERCENTAGE);
            reviewTile.getStyle().set("width","100%");
            reviewTile.getStyle().set("background-color","AliceBlue");
            reviewTile.getStyle().set("border-color","black");
            rightDiv.add(reviewTile);
        }

        //layout.add(leftDiv,rightDiv);
        add(leftDiv, rightDiv);
        this.setColspan(leftDiv, 3);
        this.setColspan(leftDiv.getComponentAt(0), 4);
    }

}
