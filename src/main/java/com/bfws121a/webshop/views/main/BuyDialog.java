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
                "Sie werden auf zu unseren Kontaktdaten weitergeleitet, wenn Sie OK drücken.<br>" +
                "Über den Button Email, öffnet sich ihr E-mail-Postfach mit einer Vorgeschriebenen Email.<br>" +
                "Sie müssen nur noch ihren Namen eintragen und die Email versenden.<br>" +
                "Wir danken Ihnen vielmals für Ihren Einkauf<div>";
        Html html = new Html(content);
        /*Label artNr = new Label("Artikelnummer: " + prod.getId());
        artNr.getStyle().set("margin-right", "auto"); */
        Button mail = new Button("Email", (e) -> {
            makeEmail(cart);
        });
        mail.addClassName("dialog-email");
        Button cancle = new Button("Abbruch", (e) -> close());
        cancle.addClassName("dialog-cancle");
        Button ok = new Button("OK");
        ok.addClassName("dialog-ok");
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
        getFooter().add(cancle,mail,ok);
        setDraggable(true);
        addClassName("dialog");
    }

    private String getNumber(List<Cart> cart) {
        String number = String.valueOf(cart.get(0).getProd().getId());
        for(int i = 1; i < cart.size(); i++) {
            number += ", " + cart.get(i).getProd().getId();
        }
        return number;
    }

    private void makeEmail(List<Cart> cart) {
        try {
            //Open mail client with "receiver", "subject", "message"
            composeEmail("kontakt@thomas-klemmbaustein-palast.de",
                    "Kaufanfrage für Artikel: " + getNumber(cart),
                    "Hallo zusammen,\r\n" + "\r\n" +
                            "Ich wäre an folgenden Artikeln interessiert: " + getNumber(cart) + "\r\n"
                            + "Über eine baldige Rückmeldung würde ich mich sehr freuen." + "\r\n" + "\r\n"
                            + "Mit freundlichen Grüßen," + "\r\n" +"\r\n" + "\r\n");
        }
        catch (Exception err) {
            err.printStackTrace();
        }
        close();
    }

    private void composeEmail(String receiver, String subject, String body) throws Exception {
        //Generating mailto-URI. Subject and body (message) has to encoded.
        String mailto = "mailto:\""+ receiver;
        mailto += "?subject=" + uriEncode(subject);
        mailto += "&body=" + uriEncode(body)+"\"";

        //Create OS-specific run command
        String cmd = "";
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")){
            cmd = "cmd.exe /c start " + mailto + "";
        }
        else if (os.contains("osx")){
            cmd = "open " + mailto;
        }
        else if (os.contains("nix") || os.contains("aix") || os.contains("nux")){
            cmd = "xdg-open " + mailto;
        }
        //Call default mail client with paramters
        Runtime.getRuntime().exec(cmd);

    }

    private String uriEncode(String in) {
        String out = new String();
        for (char ch : in.toCharArray()) {
            out += Character.isLetterOrDigit(ch) ? ch : String.format("%%%02X", (int)ch);
        }
        return out;
    }

}
