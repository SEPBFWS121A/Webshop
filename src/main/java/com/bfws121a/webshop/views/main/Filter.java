package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

import java.util.ArrayList;
import java.util.List;

public class Filter extends VerticalLayout {

    Checkbox available = new Checkbox("Nur vorrätige Artikel anzeigen");
    CheckboxGroup<String> prodtyp = new CheckboxGroup<>("Produkttyp");
    CheckboxGroup<String> prodprice = new CheckboxGroup<>("Preis");
    CheckboxGroup<String> theme = new CheckboxGroup<>("Themenwelt");

    public Filter () {
        prodtyp.setItems("Ritterburg", "Hogwards", "Bruchtal");
        prodtyp.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        prodtyp.addClassName("filter");
        prodtyp.addSelectionListener(e-> {
            List<String> selected = new ArrayList<>(e.getAllSelectedItems());
            fireEvent(new FilterTypEvent(this, selected));
        });

        prodprice.setItems("0€ - 20€", "20€ - 50€", "50€ - 100€", "100€ - 200€", "200 €+");
        prodprice.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        prodprice.addClassName("filter");

        theme.setItems("Harry Potter", "Herr der Ringe", "Mittelalter");
        theme.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        theme.addClassName("filter");

        add(available, prodtyp, prodprice, theme);
        this.addClassName("filter");
    }


    public static abstract class FilterEvent extends ComponentEvent<Filter> {
        private List<String> selected;

        protected FilterEvent(Filter source, List<String> selected) {
            super(source, false);
            this.selected = selected;
        }

        public List<String> getSelected() {
            return selected;
        }

    }

    public static class FilterTypEvent extends FilterEvent {
        FilterTypEvent(Filter source, List<String> selected) {
            super(source, selected);
        }
    }

    public Registration addFilterTypListener(ComponentEventListener<FilterTypEvent> listener) {
        return addListener(FilterTypEvent.class, listener);
    }

}
