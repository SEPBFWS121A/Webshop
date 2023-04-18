package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;

public class BuyDialog extends Dialog {

    public BuyDialog (Product prod) {
        setHeaderTitle("Kaufabwicklung");
        String content = "<div>Eine Kaufabwicklung ist entweder per Email, Telefon oder vor Ort möglich.<br> " +
                "Um den Vorgang zu vereinfach bitten wir sie die Artikelnummer des gewünschen Produktes anzugeben.<br> " +
                "Unsere Kontaktdaten sind auf der nachfolgenden Seite zu entnehmen.<div>";
        Html html = new Html(content);
        Label artNr = new Label("Artikelnummer: " + prod.getId());
        artNr.getStyle().set("margin-right", "auto");

        Button cancle = new Button("Abbruch", (e) -> close());
        cancle.addClassName("dialog");
        Button ok = new Button("OK");
        ok.addClassName("dialog");
        ok.addClickListener(clickEvent -> {
            UI.getCurrent().navigate("Kontakt");
            close();
        });


        add(html);
        getFooter().add(artNr, cancle, ok);
        setDraggable(true);
        addClassName("dialog");
    }

}
