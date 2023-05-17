package com.bfws121a.webshop.repositories;


import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.services.ProductService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@SpringBootTest
public class H2ProdDeleteByNameTest {

    private H2ProductRepository repository;

    @BeforeAll
    public static void setup() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement floriansMom = conn.createStatement();
            floriansMom.execute("CREATE TABLE IF NOT EXISTS product (\n" +
                    "    ID int primary key auto_increment,\n" +
                    "    Image varchar(256),\n" +
                    "    Name character varying,\n" +
                    "    Description character varying,\n" +
                    "    Type varchar(256),\n" +
                    "    Theme varchar(256),\n" +
                    "    Price int\n" +
                    ");");
            //floriansMom.executeQuery("select * from COLUMNS");
            floriansMom.execute("INSERT INTO product(Image, Name, Description, Type, Theme, Price) VALUES ('icons/Hogwards.png', 'Hogwards', 'Erlebe die Magie von Hogwards mit diesem atemberaubenden Baustein Set! Das Set umfasst die berühmte Schule für Hexerei und Zauberei in all ihrer majestätischen Pracht.<p>\n\n<p>Das Set enthält die verschiedenen Türme und Gebäude von Hogwarts, einschließlich des Uhrturms, der Eulerei und des Gryffindor-Turms. Jeder Turm ist detailreich gestaltet und bietet zahlreiche versteckte Überraschungen und Geheimnisse. <p>\\n\n <p>Das Set enthält auch eine Vielzahl von Figuren aus der Harry-Potter-Saga, darunter Harry Potter, Hermine Granger, Ron Weasley, Professor Dumbledore, Professor Snape, Hagrid und viele mehr. Jede Figur ist mit detaillierten Accessoires und Kostümen ausgestattet und bietet unzählige Möglichkeiten zum Spielen und Erkunden.', 'Set', 'Harry Potter',49999)");
            floriansMom.execute("INSERT INTO product(Image, Name, Description, Type, Theme, Price) VALUES ('icons/Millenium Falke.webp', 'Millenium Falke','Willkommen an Bord des größten und detailreichsten Modells des Star Wars Millennium Falcon, das jemals geschaffen wurde. Mit seinen 7.500 Teilen ist es eines der größten Baustein Modelle überhaupt! Diese fantastische Baustein Interpretation von Han Solos unvergesslichem Corellian-Frachter besitzt sämtliche Details, die sich Star Wars Fans jeden Alters nur wünschen können. Hierzu zählen auch die aufwendigen Details an der Außenseite, die Vierlingslaserkanonen oben und unten, die Landebeine, die absenkbare Einstiegsrampe und das Cockpit mit abnehmbarem Kabinendach für 4 Minifiguren. Nimm die einzelnen Rumpfplatten ab, um den äußerst detailreichen Innenbereich aus Hauptfrachtraum, Heckfrachtraum und Geschützstation zum Vorschein zu holen. Darüber hinaus verfügt dieses faszinierende Modell über austauschbare Sensorschüsseln und eine austauschbare Crew, damit du entscheiden kannst, ob du lieber klassische Star Wars Abenteuer mit Han, Leia, Chewbacca und C-3PO nachspielst oder dich mit dem älteren Han sowie mit Rey, Finn und BB-8 in die Welt aus Episode VII und VIII begibst!', 'Set', 'Star Wars', 999.99)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void kill() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement floriansMom = conn.createStatement();
            floriansMom.execute("delete from product");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteByNameTest() {
        repository = new H2ProductRepository("jdbc:h2:./test", "sa", "");
        ProductService productService;
        productService = new ProductService(repository);
        productService.deleteByName("Hogwards");
        List<Product> productList = productService.findAll();

        System.out.println(productList.get(0));
        Assertions.assertEquals(1, productList.size());
    }

}
