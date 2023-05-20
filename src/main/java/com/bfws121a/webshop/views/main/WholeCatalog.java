package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.repositories.H2ProductRepository;
import com.bfws121a.webshop.services.ProductService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "Katalog", layout = Layout.class)
@PageTitle("Produktkatalog")
public class WholeCatalog extends FormLayout {

    List<Product> prodList = new ArrayList<>();
    Filter filter;
    Catalog catalog;
    List<String> typeFilter = new ArrayList<>();
    List<String> priceFilter = new ArrayList<>();
    List<String> themeFilter = new ArrayList<>();
    Button filterButton = new Button("Filter");
    ProductService productService;

    public WholeCatalog () {
        productService = new ProductService(new H2ProductRepository("jdbc:h2:./webshop", "sa", ""));
        prodList = productService.findAll();

        // responsiveness
        this.setResponsiveSteps(
                // mobile first
                new ResponsiveStep("0", 1),
                // desktop
                new ResponsiveStep("840px", 6)
        );

        filter = new Filter(prodList);

        filter.setVisible(true);

        catalog = new Catalog(prodList);

        // initial check to set corresponding page layout
        UI.getCurrent().getPage().retrieveExtendedClientDetails(e -> setLayout(e.getWindowInnerWidth()));
        // check browser width every time it changes and set corresponding page layout
        UI.getCurrent().getPage().addBrowserWindowResizeListener(e -> setLayout(e.getWidth()));

        this.setColspan(filter, 1);
        this.setColspan(catalog, 5);

        filterButton.addClickListener(e -> {
            FilterDialog filterDialog = new FilterDialog(filter);
            filterDialog.open();
        });

        filterButton.addClassName("filter");


        filter.addFilterTypListener(this::getTypeFilter);
        filter.addFilterPriceListener(this::getPriceFilter);
        filter.addFilterThemeListener(this::getThemeFilter);

        this.getStyle().set("margin", "20px");

    }

    private void setLayout(int pageWidth) {
        removeAll();
        if (pageWidth < 840) {
            // mobile view
            add(filterButton, catalog);
        } else {
            // desktop view
            add(filter, catalog);
        }
    }

    void getTypeFilter(Filter.FilterTypEvent event) {
        typeFilter = event.getSelected();
        filterProd();
    }

    void getPriceFilter(Filter.FilterPriceEvent event) {
        priceFilter = event.getSelected();
        filterProd();
    }

    void getThemeFilter(Filter.FilterThemeEvent event) {
        themeFilter = event.getSelected();
        filterProd();
    }

    private void filterProd () {
        List<Product> listOutput = new ArrayList<>(prodList);
        if(typeFilter.size() != 0) {
            listOutput = listOutput.stream()
                    .filter(e -> typeFilter.contains(e.getType()))
                    .collect(Collectors.toList());
        }
        if(priceFilter.size() != 0) {
            listOutput = listOutput.stream()
                    .filter(e -> priceFilter.contains(e.getPriceCate()))
                    .collect(Collectors.toList());
        }
        if(themeFilter.size() != 0) {
            listOutput = listOutput.stream()
                    .filter(e -> themeFilter.contains(e.getTheme()))
                    .collect(Collectors.toList());
        }
        remove(catalog);
        catalog = new Catalog(listOutput);
        addComponentAtIndex(1,catalog);
        setColspan(catalog, 5);
    }

    public List<Product> getCatalog() {
        return prodList;
    }

}
