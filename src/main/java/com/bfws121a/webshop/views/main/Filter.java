package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Filter extends VerticalLayout {

    Checkbox available = new Checkbox("Nur vorrätige Artikel anzeigen");
    CheckboxGroup<String> prodtyp = new CheckboxGroup<>("Produkttyp");
    CheckboxGroup<String> prodprice = new CheckboxGroup<>("Preis");
    CheckboxGroup<String> theme = new CheckboxGroup<>("Themenwelt");

    public Filter () {
        prodtyp.setItems("Sets", "Einzelne Steine", "Steinsets");
        prodtyp.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        prodtyp.addClassName("filter");

        prodprice.setItems("0€ - 20€", "20€ - 50€", "50€ - 100€", "100€ - 200€", "200 €+");
        prodprice.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        prodprice.addClassName("filter");

        theme.setItems("Harry Potter", "Herr der Ringe", "Mittelalter");
        theme.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        theme.addClassName("filter");

        add(available, prodtyp, prodprice, theme);
        this.addClassName("filter");
    }


}
