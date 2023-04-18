package com.bfws121a.webshop.views.main;


import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.Route;

@Route(value = "Kontakt", layout = Layout.class)

public class Contact extends Div {

        public Contact() {
            addClassName("contact");
            VerticalLayout layout = new VerticalLayout();
            H1 heading = new H1("Kontakt");
            heading.addClassName("contact-heading");
            Div infos = new Div();
            infos.addClassName("infos");
            Paragraph bolt1 = new Paragraph("Adresse:");
            bolt1.addClassName("bolt");
            Paragraph bolt2 = new Paragraph("Email-Adresse:");
            bolt2.addClassName("bolt");
            Paragraph bolt3 = new Paragraph("Telefonnummer:");
            bolt3.addClassName("bolt");
            Paragraph bolt4 = new Paragraph("Über uns:");
            bolt4.addClassName("bolt");
            infos.add(
                    heading,
                    bolt1,
                    new Paragraph("Hohe Str. 46"),
                    new Paragraph("50667 Köln"),
                    bolt2,
                    new Paragraph("kontakt@thomas-klemmbaustein-palast.de"),
                    bolt3,
                    new Paragraph("+49 437 42874647"),
                    bolt4,
                    new Paragraph("Unsere Leidenschaft für Lego begann in unserer Kindheit und hat uns bis heute nicht losgelassen. Deshalb haben wir uns darauf spezialisiert, seltene und einzigartige Lego-Sets zu finden und diese in unserem Laden anzubieten. Bei uns finden Sie eine breite Auswahl an alten Lego-Sets, die Sie wahrscheinlich schon lange nicht mehr gesehen haben, sowie viele Lego-Steine, die Sie bei anderen Händlern nicht finden werden."),
                    new Paragraph("Ob Sie ein Liebhaber von Vintage-Lego sind oder einfach nur ein bestimmtes Set suchen, das Sie als Kind besessen haben, unser Laden ist der perfekte Ort, um Ihre Suche zu beginnen. Wir haben eine große Auswahl an Produkten, die von kleinen Sets bis hin zu den größten und seltensten Modellen reichen."),
                    new Paragraph("Besuchen Sie uns und tauchen Sie ein in die wunderbare Welt von Lego. Wir sind sicher, dass Sie etwas finden werden, das Ihre Fantasie beflügelt und Ihnen viele Stunden des Vergnügens bereiten wird. Wir freuen uns darauf, Sie in unserem Laden begrüßen zu dürfen!")
            );
            layout.add(infos);
            add(layout);

        }

}
