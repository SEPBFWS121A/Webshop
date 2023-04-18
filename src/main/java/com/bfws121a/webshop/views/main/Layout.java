package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLink;

import java.util.Optional;

public class Layout extends AppLayout {

    private final Tabs menu;

    public Layout() {

        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());

        menu = createMenu();
        //addToDrawer(createDrawerContent(menu));

    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();

        Image img = new Image("icons/Logo.png", "Logo");
        img.getStyle().set("padding-left", "10px");
        img.getStyle().set("height", "35px");
        img.getStyle().set("width", "35px");

        H2 slogan = new H2("Klemmbaustein-Palast");
        slogan.getStyle().set("margin", "10px");

        // Configure styling for the header
        layout.addClassName("header");
        //layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        //layout.add(new DrawerToggle());
        layout.add(img);
        layout.add(slogan);
        layout.add(createMenu());

        return layout;
    }

    private Tabs createMenu() {
        final Tabs tabs = new Tabs();

        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        tabs.add(createMenuItems());
        tabs.getStyle().set("border-bottom", "0");

        return tabs;
    }

    private Component[] createMenuItems() {
        return new Tab[] { createTab("Startseite", MainView.class),
                createTab("Produkte", WholeCatalog.class),
                createTab("Kontakt", Contact.class)};
    }

    private static Tab createTab(String text,
                                 Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();

        // Select the tab corresponding to currently shown view
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren()
                .filter(tab -> ComponentUtil.getData(tab, Class.class)
                        .equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }
}
