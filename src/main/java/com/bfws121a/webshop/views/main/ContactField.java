package com.bfws121a.webshop.views.main;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Div;

public class ContactField extends VerticalLayout {
    private Image productImage;
    private Label productName;
    private Label productPrice;


    public ContactField(String Image, String Label, String Value) {
        addClassName("contactField");
        Div Test = new Div();
        Test.addClassName("dingsda");
        productImage = new Image(Image,Label);
        productImage.addClassName("image-contactField");
        productName = new Label(Label);
        productName.addClassName("label-prodTile");
        productPrice = new Label(Value);
        productPrice.addClassName("label-prodTile");
        Test.add(productImage, productName, productPrice);
        add(productImage,productImage, productName, productPrice);
        this.setSizeFull();
    }
}
