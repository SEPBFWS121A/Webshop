package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AddCartDialog extends Dialog {

    public AddCartDialog (Product prod) {
        Icon icon = new Icon(VaadinIcon.CHECK_CIRCLE);
        icon.setColor("green");

        getHeader().add(icon ,new H4(" Zum Warenkorb hinzugefügt"));
        add(createProdLayout(prod));
        add(createButtonLayout(prod));

    }

    private Component createProdLayout (Product prod) {
        HorizontalLayout layout = new HorizontalLayout();
        Image image = new Image(prod.getImage(), prod.getName());
        image.addClassName("image-cart");
        layout.add(image);
        layout.add(createNameLayout(prod));
        return layout;
    }

    private Component createNameLayout (Product prod) {
        VerticalLayout layout = new VerticalLayout();
        Label name = new Label(prod.getName());
        name.addClassName("label-prodTile");
        Label price = new Label(prod.getPrice() / 100+ " €");
        price.addClassName("label-prodTile");
        layout.add(name, price);
        return layout;
    }

    private Component createButtonLayout (Product prod) {
        FormLayout layout = new FormLayout();
        Button contin = new Button("Weiter einkaufen", clickEvent -> close());
        contin.addClassName("contin");
        Button add = new Button("Zum Warenkorb", clickEvent -> {
            UI.getCurrent().navigate("Warenkorb");
            close();
        });
        add.addClassName("add");
        layout.add(contin, add);
        return layout;
    }
}
