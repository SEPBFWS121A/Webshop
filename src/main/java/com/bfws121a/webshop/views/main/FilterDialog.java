package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;

import java.util.List;

public class FilterDialog extends Dialog {

    FormLayout formLayout = new FormLayout();
    Filter filter;
    Button submit = new Button("Übernehmen");

    public FilterDialog(List<Product> productList) {

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));

        filter = new Filter(productList);

        formLayout.add(filter, submit);
        add(formLayout);

        submit.addClickListener(e -> this.close());

    }

}
