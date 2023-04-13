package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter extends VerticalLayout {


    private CheckboxGroup<String> prodtyp = new CheckboxGroup<>("Produkttyp");
    private CheckboxGroup<String> prodprice = new CheckboxGroup<>("Preis");
    private CheckboxGroup<String> prodtheme = new CheckboxGroup<>("Themenwelt");
    private List<String> type = new ArrayList<>();
    private List<String> theme = new ArrayList<>();

    public Filter (List<Product> prod) {
        fillTypeList(prod);
        prodtyp.setItems(type);
        prodtyp.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        prodtyp.addClassName("filter");
        prodtyp.addSelectionListener(e-> {
            List<String> selected = new ArrayList<>(e.getAllSelectedItems());
            fireEvent(new FilterTypEvent(this, selected));
        });
        List<String> test = new ArrayList<>();
        test.add("0€ - 20€");
        test.add("20€ - 50€");
        prodprice.setItems("0€ - 20€", "20€ - 50€", "50€ - 100€", "100€ - 200€", "200 €+");
        //prodprice.setItemEnabledProvider(item -> test.contains(item));
        prodprice.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        prodprice.addClassName("filter");

        fillThemeList(prod);
        prodtheme.setItems(theme);
        prodtheme.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        prodtheme.addClassName("filter");
        prodtheme.addSelectionListener(e -> {
            List<String> selected = new ArrayList<>(e.getAllSelectedItems());
            fireEvent(new FilterThemeEvent(this, selected));
        });

        add(prodtyp, prodprice, prodtheme);
        this.addClassName("filter");
    }

    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private void fillTypeList (List<Product> prod) {
        List<Product> helper = prod.stream()
                .filter(distinctByKey(Product::getType))
                .collect(Collectors.toList());
        for (Product product : helper) {
            type.add(product.getType());
        }
    }

    private void fillThemeList (List<Product> prod) {
        List<Product> helper = prod.stream()
                .filter(distinctByKey(Product::getTheme))
                .collect(Collectors.toList());
        for (Product product : helper) {
            theme.add(product.getTheme());
        }
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

    public static class FilterThemeEvent extends FilterEvent {

        protected FilterThemeEvent(Filter source, List<String> selected) {
            super(source, selected);
        }
    }

    public Registration addFilterTypListener(ComponentEventListener<FilterTypEvent> listener) {
        return addListener(FilterTypEvent.class, listener);
    }

    public Registration addFilterThemeListener(ComponentEventListener<FilterThemeEvent> listener) {
        return addListener(FilterThemeEvent.class, listener);
    }

}
