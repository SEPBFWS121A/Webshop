package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Cart;
import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.shared.Registration;

import java.util.List;

public class CartProdTile extends HorizontalLayout {

    private Image prodImg;

    private Label prodName;

    private Label prodPrice;

    private IntegerField prodAmount = new IntegerField();

    private Button delete = new Button(new Icon(VaadinIcon.TRASH));

    public CartProdTile (Cart cart) {
        prodImg = new Image(cart.getProd().getImage(), cart.getProd().getName());
        prodImg.addClassName("image-cartTile");
        prodName = new Label(cart.getProd().getName());
        prodName.addClassName("label-prodTile");
        prodPrice = new Label(cart.getProd().getPrice()+ " €");
        prodPrice.addClassName("label-prodTile");
        prodAmount.setValue(cart.getAmount());
        prodAmount.setMin(1);
        prodAmount.setStepButtonsVisible(true);
        prodAmount.addValueChangeListener(e -> {
            if(e.getValue() != 0) {
                cart.setAmount(e.getValue());
            }
        });
        prodAmount.getStyle().set("align-items", "center");
        delete.addClickListener(e -> {
            removeFromParent();
            System.out.println("Test");
            fireEvent(new DeleteEvent(this, cart));
        });
        add(prodImg, makeVLayout(), prodAmount, delete);
        addClassName("cart-prods");
    }

    private Component makeVLayout() {
        VerticalLayout layout = new VerticalLayout(prodName, prodPrice);
        layout.setWidth("260px");
        return layout;
    }

    public static abstract class Event extends ComponentEvent<CartProdTile> {
        private Cart selected;

        protected Event(CartProdTile source, Cart selected) {
            super(source, false);
            this.selected = selected;
        }

        public Cart getCart() {
            return selected;
        }

    }

    public static class DeleteEvent extends Event {
        protected DeleteEvent(CartProdTile source, Cart selected) {
            super(source, selected);
        }
    }

    public Registration addDeleteEventListener(ComponentEventListener<CartProdTile.DeleteEvent> listener) {
        return addListener(CartProdTile.DeleteEvent.class, listener);
    }

}
