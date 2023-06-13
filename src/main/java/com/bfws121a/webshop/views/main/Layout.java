package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLink;

import java.util.Optional;

public class Layout extends AppLayout {

    private Image img;
    private H1 slogan;
    private Tabs menu;
    HorizontalLayout layout = new HorizontalLayout();

    public Layout() {

        setPrimarySection(Section.NAVBAR);

        // initial check to set corresponding header
        UI.getCurrent().getPage().retrieveExtendedClientDetails(e -> checkBrowserWidth(e.getWindowInnerWidth()));
        // check browser width every time it changes and set corresponding header
        UI.getCurrent().getPage().addBrowserWindowResizeListener(e -> checkBrowserWidth(e.getWidth()));

        menu = createMenu();
        addToDrawer(createMenuItems());

    }

    private void checkBrowserWidth(int pageWidth) {
        if (pageWidth < 840) {
            setMobileHeader();
        } else {
            setDesktopHeader();
        }
    }

    private void setMobileHeader() {
        layout.removeAll();
        addToNavbar(true, createMobileHeaderContent());
    }

    private void setDesktopHeader() {
        layout.removeAll();
        addToNavbar(createDesktopHeaderContent());
    }

    private Component createMobileHeaderContent() {

        img = new Image("icons/Logo.png", "Logo");
        img.addClassName("header-logo");
        img.getStyle().set("padding-left", "0");
        img.getStyle().set("cursor", "pointer");
        img.addClickListener(e -> this.getUI().ifPresent(ui -> ui.navigate("")));

        slogan = new H1("TKP");
        slogan.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "var(--lumo-space-m) var(--lumo-space-l)");
        slogan.addClassNames("header-slogan");
        slogan.getStyle().set("cursor", "pointer");
        slogan.addClickListener(e -> this.getUI().ifPresent(ui -> ui.navigate("")));

        // Configure styling for the header
        layout.addClassName("header");
        //layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        layout.add(new DrawerToggle(), img, slogan, createTabWithIcon(VaadinIcon.CART, ShoppingCart.class));
        layout.expand(slogan);

        return layout;
    }

    private Component createDesktopHeaderContent() {

        img = new Image("icons/Logo.png", "Logo");
        img.addClassName("header-logo");
        img.getStyle().set("cursor", "pointer");
        img.addClickListener(e -> this.getUI().ifPresent(ui -> ui.navigate("")));

        slogan = new H1("Thomas' Klemmbaustein-Palast");
        slogan.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "var(--lumo-space-m) var(--lumo-space-l)");
        slogan.addClassNames("header-slogan");
        slogan.getStyle().set("cursor", "pointer");
        slogan.addClickListener(e -> this.getUI().ifPresent(ui -> ui.navigate("")));

        // Configure styling for the header
        layout.addClassName("header");
        //layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        Tabs tabs = createMenu();
        layout.add(img, slogan, tabs, createTabWithIcon(VaadinIcon.CART, ShoppingCart.class));
        layout.expand(tabs);

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
        tab.addClassName("header-tab-" + text);
        tab.setId("header-tab-" + text);
        return tab;
    }

    private static Tab createTabWithIcon(VaadinIcon viewIcon, Class<? extends Component> navigationTarget) {
        Icon icon = viewIcon.create();
        icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");

        final Tab tab = new Tab();
        RouterLink link = new RouterLink(navigationTarget);
        link.add(icon);
        tab.add(link);
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        tab.addClassName("header-tab");
        tab.getStyle().set("align", "auto");
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
