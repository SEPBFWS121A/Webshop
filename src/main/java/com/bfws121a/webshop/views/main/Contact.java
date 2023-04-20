package com.bfws121a.webshop.views.main;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.Route;

@Route(value = "Kontakt", layout = Layout.class)

public class Contact extends Div {

        public Contact() {
            H1 heading = new H1("Kontakt");
            heading.addClassName("contact-heading");
            HorizontalLayout fields = new HorizontalLayout();
            VerticalLayout fieldsVer = new VerticalLayout();
            Div address = new Div();
            address.addClassName("contactArea");

            Image addressIcon = new Image("icons/address.png","mail");
            addressIcon.getStyle().set("width","50px");

            Paragraph bolt1 = new Paragraph("Adresse:");
            bolt1.addClassName("bolt");
            address.add(
                    addressIcon,
                    bolt1,
                    new Paragraph("Hohe Str. 46"),
                    new Paragraph("50667 Köln"));

            Div mail = new Div();
            mail.addClassName("contactArea");

            Image mailIcon = new Image("icons/mail.png","mail");
            mailIcon.getStyle().set("width","50px");

            Paragraph bolt2 = new Paragraph("Email-Adresse:");
            bolt2.addClassName("bolt");

            mail.add(
                    mailIcon,
                    bolt2,
                    new Paragraph("kontakt@thomas-klemmbaustein-palast.de"));

            Div phone = new Div();
            phone.addClassName("contactArea");

            Image phoneIcon = new Image("icons/phone.png","mail");
            phoneIcon.getStyle().set("width","50px");

            Paragraph bolt3 = new Paragraph("Telefonnummer:");
            bolt3.addClassName("bolt");
            phone.add(
                    phoneIcon,
                    bolt3,
                    new Paragraph("+49 437 42874647"));

            UI.getCurrent().getPage().retrieveExtendedClientDetails(receiver -> {
                int screenWidth = receiver.getScreenWidth();
                if(screenWidth >= 1000) fields.add(mail,address, phone);
                else fieldsVer.add(mail,address, phone);
            });
            Page page = UI.getCurrent().getPage();
            page.addBrowserWindowResizeListener(
                    event -> {
                        if(event.getWidth() >= 1000) fields.add(mail,address, phone);
                        else fieldsVer.add(mail,address, phone);
                        Notification.show("Window width="
                                + event.getWidth()
                                + ", height=" + event.getHeight());
                    });




            Div infos = new Div();
            infos.getStyle().set("margin-left","20px");
            infos.addClassName("infos");

            Paragraph bolt4 = new Paragraph("Über uns:");
            bolt4.addClassName("bolt");
            infos.add(
                    bolt4,
                    new Paragraph("Unsere Leidenschaft für Lego begann in unserer Kindheit und hat uns bis heute nicht losgelassen. Deshalb haben wir uns darauf spezialisiert, seltene und einzigartige Lego-Sets zu finden und diese in unserem Laden anzubieten. Bei uns finden Sie eine breite Auswahl an alten Lego-Sets, die Sie wahrscheinlich schon lange nicht mehr gesehen haben, sowie viele Lego-Steine, die Sie bei anderen Händlern nicht finden werden."),
                    new Paragraph("Ob Sie ein Liebhaber von Vintage-Lego sind oder einfach nur ein bestimmtes Set suchen, das Sie als Kind besessen haben, unser Laden ist der perfekte Ort, um Ihre Suche zu beginnen. Wir haben eine große Auswahl an Produkten, die von kleinen Sets bis hin zu den größten und seltensten Modellen reichen."),
                    new Paragraph("Besuchen Sie uns und tauchen Sie ein in die wunderbare Welt von Lego. Wir sind sicher, dass Sie etwas finden werden, das Ihre Fantasie beflügelt und Ihnen viele Stunden des Vergnügens bereiten wird. Wir freuen uns darauf, Sie in unserem Laden begrüßen zu dürfen!")
            );
            infos.getStyle().set("margin","0 5%");
            infos.getStyle().set("text-align","center");
            add(heading,fields,fieldsVer,infos);
        }

}
