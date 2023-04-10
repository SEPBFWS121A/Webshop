package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "Katalog", layout = Layout.class)
public class WholeCatalog extends HorizontalLayout {

    List<Product> prodList = new ArrayList<>();

    public WholeCatalog () {
        prodList.add(new Product(12345, "icons/Ritterburg.png", "Ritterburg", "<p>Es war einmal ein Kind, das gerne mit LEGO® Steinen baute. Heute ist dieses Kind längst erwachsen – und beim Bauen steht der Genuss im Vordergrund. Die Burg der Löwenritter (10305) zur Feier des 90-jährigen LEGO Jubiläums ist eine Neuinterpretation des ursprünglichen LEGO Burgensystems. Dieses Bauset stand schon seit vielen Jahren auf dem Wunschzettel unzähliger LEGO Fans.</p>\n" +
                "<p>Spannende Abenteuergeschichten<br>\n" +
                "In jedem Winkel dieses imposanten Sets erwarten dich Überraschungen. Entdecke die atemberaubenden Details auf allen Seiten des Modells. Klapp die Burg dann auf, um das Innenleben zu erkunden. In der Burg verbergen sich Geheimgänge, bewegliche Mauern, unsichtbare Verstecke, eine mittelalterliche Zugbrücke und hochziehbare Fallgitter. Auch eine Waffenkammer, eine Mühle mit drehbarem Mühlrad, Burgfriede und Ecktürme sind vorhanden. Außerdem laden 22 Minifiguren immer wieder zu spannenden Belagerungen und waghalsigen Fluchtversuchen ein.</p>\n" +
                "<p>Nimm dir Zeit für dich selbst<br>\n" +
                "LEGO Premium-Sets für Erwachsene bieten dir einen faszinierenden Zeitvertreib. Diese Burg ist nicht nur ein fesselndes Bauprojekt für dich selbst, sondern auch ein grandioses Geschenk für alle, die sich für Geschichte und Burgen begeistern.</p>\n" +
                "<ul><li> Neuinterpretation eines Klassikers: Genieße es, all die Details der Burg der Löwenritter (10305) zu bauen. Die klassischen LEGO® Burgen aus längst vergangenen Zeiten dienten diesem Modell als Vorbild\n" +
                "</li><li> Auf vielfachen Wunsch der LEGO® Fans: Nach einer Umfrage auf der LEGO Ideas Plattform, an der sich 55.000 LEGO Fans beteiligten, wurde dieses Set entworfen, um das 90-jährige LEGO Jubiläum zu feiern\n" +
                "</li><li> 4.514 Teile: Dieses legendäre Modell bietet dir stundenlangen Bauspaß und erfordert beim Bauen deine ganze Aufmerksamkeit. Entdecke die Details auf allen Seiten und klapp die Burg dann auf, um das Innenleben zu erkunden\n" +
                "</li><li> Jede Menge Details aus dem Mittelalter: Zieh die Zugbrücke und das Fallgitter hoch, erkunde die Geheimgänge, flüchte aus dem Verlies, dreh das Wasserrad der Mühle und rüste dich in der Waffenkammer für die nächste Schlacht\n" +
                "</li><li> Geheimversteck: Baue Geheimverstecke für die Waldbewohner. Lass sie durch die Falltür ins Verlies purzeln, wenn sie in die Burg eindringen. Verhilf ihnen dann durch den Geheimgang zur Flucht\n" +
                "</li><li> 22 Minifiguren: Eigens für dieses Set entworfene Minifiguren, beispielsweise die Königin, Ritter, Bogenschützen, ein Zauberer und die Waldbewohner, lassen dich lebhafte Abenteuer darstellen\n" +
                "</li><li> Abmessungen: Ungeöffnet ist die Burg 38&nbsp;cm hoch, 44&nbsp;cm breit und 33&nbsp;cm tief\n" +
                "</li><li> Für Erwachsene, deren Fantasie niemals erlischt: Dieses LEGO® Set gehört zu einer ganzen Reihe von Bausets für erwachsene LEGO Fans, die sich für atemberaubendes Design, aufwendige Details und elegante Architektur begeistern\n" +
                "</li><li> Hochwertige Materialien: LEGO® Bausteine werden aus hochwertigen Materialien gefertigt. Sie sind einheitlich und kompatibel und lassen sich jedes Mal fest zusammenstecken und mühelos wieder trennen – und das schon seit 1958\n" +
                "</li><li> Garantiert sicher: Bei LEGO® Teilen stehen Sicherheit und Qualität an erster Stelle. Deshalb werden sie streng getestet, damit sie sich zu einem robusten Modell zusammenstecken lassen</li></ul>", 229.99));
        prodList.add(new Product(12346, "icons/Hogwards.png", "Hogwards", "Egal", 499.99));
        prodList.add(new Product(12347, "icons/Bruchtal.png", "Bruchtal", "Egal", 499.99));

        Filter filter = new Filter();
        Catalog catalog = new Catalog(prodList);
        add(filter, catalog);
        this.setJustifyContentMode(JustifyContentMode.CENTER);

    }

    public List<Product> getCatalog() {
        return prodList;
    }

}
