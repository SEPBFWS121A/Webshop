package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "Katalog", layout = Layout.class)
public class WholeCatalog extends FormLayout {

    final List<Product> prodList = new ArrayList<>();
    Filter filter;
    Catalog catalog;
    List<String> typeFilter = new ArrayList<>();
    List<String> priceFilter = new ArrayList<>();
    List<String> themeFilter = new ArrayList<>();
    Button filterButton = new Button("Filter");

    public WholeCatalog () {

        // responsiveness
        this.setResponsiveSteps(
                // mobile first
                new ResponsiveStep("0", 1),
                // desktop
                new ResponsiveStep("840px", 6)
        );

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
                "</li><li> Garantiert sicher: Bei LEGO® Teilen stehen Sicherheit und Qualität an erster Stelle. Deshalb werden sie streng getestet, damit sie sich zu einem robusten Modell zusammenstecken lassen</li></ul>", "Set", "Mittelalter", 229.99));
        prodList.add(new Product(12346, "icons/Hogwards.png", "Hogwards","Erlebe die Magie von Hogwards mit diesem atemberaubenden Baustein Set! Das Set umfasst die berühmte Schule für Hexerei und Zauberei in all ihrer majestätischen Pracht.<p>\n" +
                "<p>Das Set enthält die verschiedenen Türme und Gebäude von Hogwarts, einschließlich des Uhrturms, der Eulerei und des Gryffindor-Turms. Jeder Turm ist detailreich gestaltet und bietet zahlreiche versteckte Überraschungen und Geheimnisse. <p>\n" +
                "<p>Das Set enthält auch eine Vielzahl von Figuren aus der Harry-Potter-Saga, darunter Harry Potter, Hermine Granger, Ron Weasley, Professor Dumbledore, Professor Snape, Hagrid und viele mehr. Jede Figur ist mit detaillierten Accessoires und Kostümen ausgestattet und bietet unzählige Möglichkeiten zum Spielen und Erkunden.", "Set", "Harry Potter",499.99));
        prodList.add(new Product(12347, "icons/Bruchtal.png", "Bruchtal", "Dieses Icon DER HERR DER RINGE Sammlerstück bringt dich direkt nach Bruchtal, wo die berühmte Reise der Gefährten begann. Diese imposante Nachbildung eines Ausschnitts von Mittelerde ist ein beeindruckendes 6.167-teiliges Bauprojekt für Erwachsene. Filmfans werden von den unzähligen Details begeistert sein. <p>\n" +
                "<p>Erwecke legendäre Szenen zum Leben<p>\n" +
                "<p>Bäume mit dichtem Blätterdach vermitteln den Eindruck, man befände sich tief im Wald von Bruchtal. Das Bauset beinhaltet magische Details wie eine Elben-Schmiede, Elronds unaufgeräumtes Studierzimmer, die Scherben Narsils sowie Gemälde und Statuen aus der Geschichte von Mittelerde. 15 Minifiguren hauchen dieser imposanten Kulisse Leben ein. Du kannst die Beine der Minifiguren abnehmen, um sie an den Tisch zu setzen und die legendäre Szene des Rats von Elrond nachzustellen.", "Set", "Herr der Ringe", 499.99));
        prodList.add(new Product(12348, "icons/Blaue Steine.jpg", "Blaue Steine", "Tauche ein in die endlose Welt des Bauens und der Kreativität mit diesen blauen Bausteinen in verschiedenen Größen! Das Set enthält eine Vielzahl von Bausteinen in unterschiedlichen Formen und Größen, die perfekt für Kinder und Erwachsene geeignet sind, die ihrer Fantasie freien Lauf lassen möchten.<p>\n" +
                "<p>Die blauen Bausteine sind aus hochwertigem Kunststoff gefertigt und bieten eine hervorragende Qualität, die langlebig und robust ist. Sie sind einfach zu handhaben und zu kombinieren und können immer wieder neu arrangiert werden, um unendlich viele Designs und Kreationen zu erstellen.", "Steine", "Klötze", 11.99));
        prodList.add(new Product(12349, "icons/Ersatz Steine Set.jpg", "Ersatz-Steine-Set","Das Ersatzsteine-Set ist die perfekte Lösung für alle, die ihre Lieblings-Klötze-Sets reparieren oder erweitern möchten. Dieses Set enthält eine Vielzahl von Ersatzsteinen in verschiedenen Formen und Farben, um sicherzustellen, dass Ihre Modelle immer komplett und funktionsfähig sind.</p>\n" +
                "<p> Das Set enthält Steine in verschiedenen Größen und Formen, einschließlich klassischer Steine, Räder, Scharniere, Gelenke und vieles mehr. So können Sie fehlende oder beschädigte Steine in fast allen Klötze-Sets ersetzen oder sogar neue Kreationen erschaffen.\n" +
                "Diese Ersatzsteine sind aus hochwertigem, langlebigem Kunststoff gefertigt und halten auch bei intensiver Nutzung stand. Das Set wird in einer praktischen Aufbewahrungsbox geliefert, die es einfach macht, die Steine zu organisieren und aufzubewahren.\n" +
                "Das Ersatzsteine-Set ist eine großartige Ergänzung für jede Klötze-Sammlung und eignet sich auch perfekt als Geschenk für Lego-Enthusiasten jeden Alters. Es gibt Ihnen die Freiheit, kreativ zu werden und Ihre eigenen Designs zu erstellen, während Sie sicherstellen, dass Ihre vorhandenen Klötze-Sets immer komplett und funktionsfähig bleiben.\n", "Steine", "Klötze", 15.99));
        prodList.add(new Product(12350, "icons/Kamera.png", "Vintage Kamera","Die Vintage Kamera ist ein beeindruckendes Modell im Retro-Stil, dass das Aussehen einer klassischen Kamera der 1950er und 60er Jahre nachbildet. </p>\n" +
                "<p>Die Kamera ist aus hochwertigen Steinen gefertigt und mit besonderen Details gestaltet, die die Vintage-Kamera perfekt nachbilden. Der schwenkbare Sucher, das ausziehbare Objektiv und der einstellbare Fokus sorgen für ein realistisches und authentisches Erscheinungsbild. \n" +
                "Obwohl diese Kamera nicht tatsächlich funktioniert und keine Fotos machen kann, ist sie dennoch ein wunderschönes und originelles Modell, dass sich ideal als Dekoration für jedes Zuhause eignet. Das Set enthält auch eine Kameratasche, um das Modell aufzubewahren und zu schützen.</p>\n" +
                "<p>Die Vintage Kamera ist eine einzigartige Ergänzung für jede Klötze-Sammlung und wird sicherlich die Aufmerksamkeit auf sich ziehen. Es ist ein großartiges Geschenk für Klötze-Enthusiasten oder Fotografie-Liebhaber, die ein stilvolles Stück für ihr Zuhause suchen.\n", "Set", "Vintage Lego Sets", 99.99));
        prodList.add(new Product(12351, "icons/Eldorado.jpg", "Eldorado Fortress 1989","Das Eldorado Fortress Klötze Set ein einzigartiges und limitiertes Set, das die Herzen aller Baustein-Fans erobert hat. Dieses Set ist eine Hommage an die klassische Lego-Piraten-Themenwelt, die in den 80er und 90er Jahren eingeführt wurde. </p>\n" +
                "<p>Insgesamt besteht dieses Lego Set aus 462 Teilen und 8 Minifiguren. Ein besonderes Highlight sind die Kanonen und die im Detail geschmückten Einzelteile des Kastells\n" +
                "Das Baustein Piratenset von 1989 ist aufgrund seiner limitierten Verfügbarkeit zu einem begehrten Sammlerstück geworden. Es ist ein Symbol für die goldenen Zeiten des Lego-Designs und der Piraten-Themenwelt. Dieses Set ist ein Muss für jeden Baustein-Sammler oder Fan von Piratengeschichten.\n", "Set", "Vintage Lego Sets", 299.99));
        prodList.add(new Product(12352, "icons/Titanic.webp", "Titanic","Seit ihrer schicksalhaften Jungfernfahrt im Jahr 1912 hat die berühmte Titanic die Fantasie vieler Menschen rund um den Globus geweckt. Mit der kolossalen Titanic (10294) zum Sammeln, Bauen und Ausstellen kannst du dem Ozeanriesen gedenken. Dieses Modell im Maßstab 1:200 ist in 3 Segmente unterteilt und bildet die Merkmale der Titanic originalgetreu nach. Im Inneren sind der Speisesaal der 1. Klasse, die große Treppe, einer der Kesselräume und viele Kabinen der unterschiedlichen Passagierklassen untergebracht. Erwecke die Geschichte der Titanic zum Leben, indem du Details wie die Brücke, das Promenadendeck, den Lesesalon und das Schwimmbecken nachbildest.\n" +
                "Mit einer Länge von 135 cm zählt das Schiff zu den größten Baustein-Modellen aller Zeiten. Mehr als 9.000 Teile bieten viele Stunden Bauvergnügen, das schließlich in einem spektakulären Hingucker gipfelt, den du gerne ausstellen wirst.\n", "Set", "Vintage Lego Sets", 399.99));
        prodList.add(new Product(12353, "icons/Millenium Falke.webp", "Millenium Falke","Willkommen an Bord des größten und detailreichsten Modells des Star Wars Millennium Falcon, das jemals geschaffen wurde. Mit seinen 7.500 Teilen ist es eines der größten Baustein Modelle überhaupt! Diese fantastische Baustein Interpretation von Han Solos unvergesslichem Corellian-Frachter besitzt sämtliche Details, die sich Star Wars Fans jeden Alters nur wünschen können. Hierzu zählen auch die aufwendigen Details an der Außenseite, die Vierlingslaserkanonen oben und unten, die Landebeine, die absenkbare Einstiegsrampe und das Cockpit mit abnehmbarem Kabinendach für 4 Minifiguren. Nimm die einzelnen Rumpfplatten ab, um den äußerst detailreichen Innenbereich aus Hauptfrachtraum, Heckfrachtraum und Geschützstation zum Vorschein zu holen. Darüber hinaus verfügt dieses faszinierende Modell über austauschbare Sensorschüsseln und eine austauschbare Crew, damit du entscheiden kannst, ob du lieber klassische Star Wars Abenteuer mit Han, Leia, Chewbacca und C-3PO nachspielst oder dich mit dem älteren Han sowie mit Rey, Finn und BB-8 in die Welt aus Episode VII und VIII begibst!", "Set", "Star Wars", 999.99));
        prodList.add(new Product(12354, "icons/Bowser.jpg", "Der Mächtige Bowser","Das Baustein-Set „Der mächtige Bowser“ (71411) zum Bauen, Spielen und Ausstellen lässt dich den König der Koopas würdigen. Diese Figur wird unter anderem aus Baustein Elementen gebaut, die im Oktober 2022 neu herauskommen, um Bowsers Stacheln exakt nachzubilden. Zu dem Modell gehören auch ein Feuerball-Shooter und ein Knopf zur Steuerung der Kopf- und Halsbewegungen. Seine Arme und Finger sind ebenfalls beweglich!<p>\n" +
                "<p>Das Set ist ein tolles Geschenk für jeden Super Mario Fan und bietet der ganzen Familie riesigen Bau- und Spielspaß. Eine Schritt-für-Schritt-Bauanleitung führt dich durch das komplexe Bauprojekt.\n", "Set", "Super Mario", 189.99));



        filter = new Filter(prodList);

        filter.setVisible(true);

        catalog = new Catalog(prodList);

        // initial check to set corresponding page layout
        UI.getCurrent().getPage().retrieveExtendedClientDetails(e -> setLayout(e.getWindowInnerWidth()));
        // check browser width every time it changes and set corresponding page layout
        UI.getCurrent().getPage().addBrowserWindowResizeListener(e -> setLayout(e.getWidth()));

        this.setColspan(filter, 1);
        this.setColspan(catalog, 5);

        filterButton.addClickListener(e -> {
            FilterDialog filterDialog = new FilterDialog(filter);
            filterDialog.open();
        });

        filterButton.addClassName("filter");


        filter.addFilterTypListener(this::getTypeFilter);
        filter.addFilterPriceListener(this::getPriceFilter);
        filter.addFilterThemeListener(this::getThemeFilter);

        this.getStyle().set("margin", "20px");

    }

    private void setLayout(int pageWidth) {
        removeAll();
        if (pageWidth < 840) {
            // mobile view
            add(filterButton, catalog);
        } else {
            // desktop view
            add(filter, catalog);
        }
    }

    void getTypeFilter(Filter.FilterTypEvent event) {
        typeFilter = event.getSelected();
        filterProd();
    }

    void getPriceFilter(Filter.FilterPriceEvent event) {
        priceFilter = event.getSelected();
        filterProd();
    }

    void getThemeFilter(Filter.FilterThemeEvent event) {
        themeFilter = event.getSelected();
        filterProd();
    }

    private void filterProd () {
        List<Product> listOutput = new ArrayList<>(prodList);
        if(typeFilter.size() != 0) {
            listOutput = listOutput.stream()
                    .filter(e -> typeFilter.contains(e.getType()))
                    .collect(Collectors.toList());
        }
        if(priceFilter.size() != 0) {
            listOutput = listOutput.stream()
                    .filter(e -> priceFilter.contains(e.getPriceCate()))
                    .collect(Collectors.toList());
        }
        if(themeFilter.size() != 0) {
            listOutput = listOutput.stream()
                    .filter(e -> themeFilter.contains(e.getTheme()))
                    .collect(Collectors.toList());
        }
        remove(catalog);
        catalog = new Catalog(listOutput);
        addComponentAtIndex(1,catalog);
        setColspan(catalog, 5);
    }

    public List<Product> getCatalog() {
        return prodList;
    }

}
