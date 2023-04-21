package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Cart;
import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;

import java.util.List;

public class BuyDialog extends Dialog {

    public BuyDialog (List<Cart> cart) {
        setHeaderTitle("Kaufabwicklung");
        String content = "<div>Eine Kaufabwicklung ist entweder per Email, Telefon oder vor Ort möglich.<br> " +
                "Um den Vorgang zu vereinfach bitten wir sie die Artikelnummer des gewünschen Produktes anzugeben.<br> " +
                "Unsere Kontaktdaten sind auf der nachfolgenden Seite zu entnehmen.<div>";
        Html html = new Html(content);
        /*Label artNr = new Label("Artikelnummer: " + prod.getId());
        artNr.getStyle().set("margin-right", "auto"); */

        Button cancle = new Button("Abbruch", (e) -> close());
        cancle.addClassName("dialog");
        Button ok = new Button("OK");
        ok.addClassName("dialog");
        ok.addClickListener(clickEvent -> {
            UI.getCurrent().navigate("Kontakt");
            close();
        });
        Label number = new Label();
        number.addClassName("label-prodTile");
        if(cart.size() > 1) {
            number.setText("Artikelnummern: " + getNumber(cart));
        } else {
            number.setText("Artikelnummer: " + cart.get(0).getProd().getId());
        }

        add(html, number);
        getFooter().add(cancle, ok);
        setDraggable(true);
        addClassName("dialog");
    }

    private String getNumber(List<Cart> cart) {
        String number = cart.get(0).getProd().getId() + ", ";
        for(int i = 1; i < cart.size(); i++) {
            if(i == cart.size()-1) {
                number += cart.get(i).getProd().getId();
            } else {
                number += cart.get(i).getProd().getId() + ", ";
            }
        }
        return number;
    }

}
