package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Footer extends FormLayout {

    VerticalLayout left = new VerticalLayout();
    VerticalLayout right = new VerticalLayout();

    public Footer() {

        Image img = new Image("icons/Logo.png", "Logo");
        img.getStyle().set("max-height", "100px");
        img.getStyle().set("max-width", "100px");

        H4 homepage = new H4("Startseite");
        homepage.addClassName("footer-element");
        homepage.getStyle().set("color", "white");
        homepage.addClickListener(e -> this.getUI().ifPresent(ui -> ui.navigate("")));

        this.setResponsiveSteps(
                // mobile first
                new ResponsiveStep("0", 1),
                // desktop
                new ResponsiveStep("800px", 2)
        );
        this.addClassName("footer");
        this.setSizeFull();

        // add footer elements
        left.add(img, homepage);
        add(left, right);
    }

}
