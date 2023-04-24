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
        reviews.add(new Review(12349, "Tommy Hillebrandt", true, "10.04.2023",
                "Tolles Ersatz Set", "Ich habe das Ersatzsteine gekauft und bin absolut begeistert davon. Das Set enthält eine breite Palette von Ersatzsteinen in verschiedenen Größen, Farben und Formen, so dass ich in der Lage war, fehlende oder beschädigte Teile in meinen Baustein-Sets leicht zu ersetzen.\n" +
                "Die Qualität der Ersatzsteine ist hervorragend und sie passen perfekt zu meinen vorhandenen Lego-Modellen. Ich war auch beeindruckt von der Aufbewahrungsbox, die mit dem Set geliefert wurde, da sie es einfach macht, die Steine zu organisieren und aufzubewahren.\n"));
        reviews.add(new Review(12350, "Boris Becker", true, "11.04.2023",
                "Cooles Endprodukt trotz Aufwand", "1.\tNettes Design mit interessanten Baulösungen. War zwar schnell zusammengebaut. Aber die 179 Teile machen etwas her am Schluss."));
        reviews.add(new Review(12350, "Bernd Hacker", true, "20.04.2023",
                "Kamera Top - Box Flopp", "Es ist eine limitierte Auflage von ca. 40.000 Stück und hat ein gutes Baugefühl. Ich mag dieses Set sehr, aber die Box dieses exklusiven Sammlerstücks sieht ein bisschen billig aus"));
        reviews.add(new Review(12351, "Silke Schneider", true, "02.04.2023",
                "Nostalgie pur", "Ich bin ein großer Fan der Piraten-Themenwelt und dieses Set von 1989 hat mich nicht enttäuscht. Die Details sind erstaunlich und das Kastell sieht fantastisch aus, wenn es gebaut ist."));
        reviews.add(new Review(12352, "Heike Bauch", true, "06.04.2023",
                "Beeindruckendes Produkt", "Das Lego Titanic-Set ist absolut beeindruckend! Es ist ein großartiges Modell, das dem Originalschiff bis ins kleinste Detail ähnelt. Es ist erstaunlich, wie viele Stunden man damit verbringen kann, dieses Set zu bauen und wie beeindruckend es aussieht, wenn es fertig ist."));
        reviews.add(new Review(12352, "Gandalf Rauch", true, "09.04.2023",
                "Top Qualität", "Ich war begeistert von der Qualität der Lego-Steine und der Präzision, mit der die einzelnen Elemente zusammengesetzt wurden. Es war ein tolles Gefühl, das Schiff Schritt für Schritt zum Leben zu erwecken. Die Miniaturfiguren sind ebenfalls großartig und tragen zur Authentizität des Modells bei."));
        reviews.add(new Review(12353, "Bernd Stromberg", true, "20.04.2023",
                "Einfach ein Genuss", "Nach Monatelangem überlegen und schauen im Netz habe ich mir nun kurz vor Ostern den Traum erfüllt. Hatte bestimmt 25 Jahre keinen Legostein mehr in der Hand. Aber nach dem Öffnen der Kartons war ich sofort wieder in der Materie. Der Aufbau hat insgesamt 11 Tage (immer ein paar Stunden nach Feierabend ) gedauert und hat Mega Spaß gemacht. Würde den Falken sofort nochmal bauen! Die ganzen Details zeigen mir, dass dort jemand echt mit Liebe designet hat."));
        reviews.add(new Review(12354, "Laura Vollberg", true, "19.04.2023",
                "Bauset für jedermann/frau", "Das Set ist ein absolutes „muss“ Schritt für Schritt merkt man bei diesem Set wie gut durchdacht das Ganze ist. Ich bin total begeistert von dem Aussehen, der Größe und den beweglichen Teilen. Ich würde dieses Set jedem empfehlen. Egal ob groß oder klein. "));
        reviews.add(new Review(12354, "Thommy Heimweh", true, "20.04.2023",
                "Top Geschenk", "Ich bin durch Zufall auf dieses Set gestoßen, als ich auf der Suche nach einem Kommunionsgeschenk für meinen Neffen war. Als er es auspackte ist er vor Freude so hoch gesprungen, dass er Gott einen High Five geben konnte. Alles in allem ein Top Geschenk! "));

    }

    public void addReview(Review review) {
        reviews.add(review);
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
