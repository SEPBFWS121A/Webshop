package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "", layout = Layout.class)
public class MainView extends VerticalLayout {

    private Button navigate;

    public MainView() {
        navigate = new Button("Katalog öffnen");
        navigate.addClickListener(e -> {
            UI.getCurrent().navigate("Katalog");
        });
        navigate.addClickShortcut(Key.ENTER);

        setMargin(true);

        add(navigate, new Footer());
    }

}
