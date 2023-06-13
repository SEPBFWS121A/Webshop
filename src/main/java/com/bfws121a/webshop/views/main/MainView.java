package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.object.Review;
import com.bfws121a.webshop.repositories.H2ProductRepository;
import com.bfws121a.webshop.services.ProductService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Main")
@Route(value = "", layout = Layout.class)
public class MainView extends FormLayout {

    WholeReview reviews = new WholeReview();
    List<Product> prodList = new ArrayList<>();
    List<Product> prodList2 = new ArrayList<>();
    FormLayout startInfo = new FormLayout();
    Div nameLayout = new Div();
    Div leftDiv = new Div();
    Div rightDiv = new Div();
    HorizontalLayout highlightProducts = new HorizontalLayout();
    HorizontalLayout newProducts = new HorizontalLayout();
    ProductService productService;

    public MainView() {

        this.getStyle().set("margin", "15px");

        // responsiveness
        this.setResponsiveSteps(
                // mobile first
                new ResponsiveStep("0", 1),
                // desktop
                new ResponsiveStep("1050px", 4)
        );
        startInfo.setResponsiveSteps(
                // mobile first
                new ResponsiveStep("0", 1),
                // desktop
                new ResponsiveStep("550px", 4)
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
        nameLayout.getStyle().set("align-self", "flex-start");

        startInfo.add(logo,nameLayout);
        startInfo.setColspan(nameLayout, 3);
        leftDiv.add(startInfo);

        Paragraph highlightsTitle = new Paragraph("Unsere Highlights:");
        highlightsTitle.getStyle().set("font-size","x-large");
        highlightsTitle.getStyle().set("font-weight","bold");
        leftDiv.add(highlightsTitle);

        productService = new ProductService(new H2ProductRepository(System.getenv("FHDW_WEBSHOP_DB_URL"), System.getenv("FHDW_WEBSHOP_DB_USER"), System.getenv("FHDW_WEBSHOP_DB_PASSWORD")));
        prodList = productService.searchByProductTag("bestseller");

        SelectiveCatalog catalog = new SelectiveCatalog(prodList);
        catalog.getStyle().set("width","100%");
        highlightProducts.add(catalog);
        highlightProducts.getStyle().set("overflow", "auto");
        highlightProducts.getStyle().set("display", "block");
        leftDiv.add(highlightProducts);

        Paragraph newProdsTitle = new Paragraph("Neu bei uns:");
        newProdsTitle.getStyle().set("font-size","x-large");
        newProdsTitle.getStyle().set("font-weight","bold");

        prodList2 = productService.searchByProductTag("bestseller");

        SelectiveCatalog catalog2 = new SelectiveCatalog(prodList2);

        newProducts.add(catalog2);
        newProducts.getStyle().set("overflow", "auto");
        newProducts.getStyle().set("display", "block");
        leftDiv.add(newProdsTitle,newProducts);

        rightDiv.addClassName("mainDiv");

        Paragraph reviewTitle = new Paragraph("Bewertungen:");
        reviewTitle.getStyle().set("font-size","x-large");
        reviewTitle.getStyle().set("font-weight","bold");
        rightDiv.add(reviewTitle);

        /*for (Review review : reviews.getReviews(0)) {
            ReviewTile reviewTile = new ReviewTile(review);
            reviewTile.addClassName("reviews-prodPage");
            reviewTile.addClassName("reviewTile-prodPage");
            reviewTile.setWidth(50, Unit.PERCENTAGE);
            reviewTile.getStyle().set("width","100%");
            reviewTile.getStyle().set("background-color","AliceBlue");
            reviewTile.getStyle().set("border-color","black");
            rightDiv.add(reviewTile);
        }*/

        //layout.add(leftDiv,rightDiv);
        add(leftDiv, rightDiv);
        this.setColspan(leftDiv, 3);
        this.setColspan(leftDiv.getComponentAt(0), 4);
    }

}
