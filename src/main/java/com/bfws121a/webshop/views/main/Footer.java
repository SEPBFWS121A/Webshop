package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Footer extends FormLayout {

    VerticalLayout left = new VerticalLayout();
    VerticalLayout right = new VerticalLayout();

    public Footer() {

        H1 slogan = new H1("Thomas Lego Shop");
        slogan.getStyle().set("color", "white");

        H3 homepage = new H3("Startseite");
        homepage.addClassName("clickable");
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
        left.add(slogan, homepage);
        add(left);
    }

}
