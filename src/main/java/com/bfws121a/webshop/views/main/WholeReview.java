package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Review;

import java.util.ArrayList;
import java.util.List;

public class WholeReview {

    List<Review> reviews = new ArrayList<>();

    public WholeReview() {
        reviews.add(new Review(12345, "Max Mustermann", true, "08.04.2023",
                "Tolles Produkt", "Tolles Produkt, gerne wieder!"));
        reviews.add(new Review(12345, "Maria Musterfrau", true, "09.04.2023",
                "Tolles Produkt", "Tolles Produkt, gerne wieder!"));
        reviews.add(new Review(12346, "Max Mustermann", false, "07.04.2023",
                "Toller Laden, schlechtes Produkt", "Toller Laden, nur das Produkt ist nicht so toll, dennoch gerne wieder!"));
        reviews.add(new Review(0, "Natasha Patel", false, "01.04.2023",
                "Ein wahres Paradies für Lego-Sammler!", "Thomas' Klemmbaustein Palast ist einfach der beste Laden für alle Lego-Fans da draußen! Ich konnte hier eine Sammlung seltener, alter Lego-Sets und Steine finden, die ich nirgendwo anders gefunden hätte. Ein wahres Paradies für jeden Sammler!"));
        reviews.add(new Review(0, "Julian Kim", false, "01.04.2023",
                "Fantastische Qualität und freundliches Personal", "Ich war wirklich beeindruckt von der Auswahl an alten Lego-Sets und Steinen bei Thomas' Klemmbaustein Palast. Die Qualität der Produkte war einfach unglaublich, und das Personal war sehr freundlich und hilfsbereit bei der Suche nach den perfekten Teilen für meine Kreationen."));
        reviews.add(new Review(0, "Oscar Martinez", false, "07.04.2023",
                "Die perfekte Anlaufstelle für alle Lego-Fans", "Als begeisterter Lego-Fan bin ich immer auf der Suche nach neuen Möglichkeiten, meine Sammlung zu erweitern. Bei Thomas' Klemmbaustein Palast habe ich genau das gefunden, wonach ich gesucht habe. Die Preise sind fair und die Auswahl ist einfach fantastisch!"));
    }

    public List<Review> getReviews(int id) {
        List<Review> productReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getProductId() == id) {
                productReviews.add(review);
            }
        }
        return productReviews;
    }

}
