package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.services.ProductService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.util.List;

@SpringBootTest
public class H2ProdRepoSearchByNameTest {
    private ProductRepository repository;

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
                    "    Price int,\n" +
                    "    producttags varchar(255)\n" +
                    ");");
            //floriansMom.executeQuery("select * from COLUMNS");
            floriansMom.execute("INSERT INTO product(Image, Name, Description, Type, Theme, Price, producttags) VALUES ('icons/Hogwards.png', 'Hogwards', 'Erlebe die Magie von Hogwards mit diesem atemberaubenden Baustein Set! Das Set umfasst die berühmte Schule für Hexerei und Zauberei in all ihrer majestätischen Pracht.<p>\n\n<p>Das Set enthält die verschiedenen Türme und Gebäude von Hogwarts, einschließlich des Uhrturms, der Eulerei und des Gryffindor-Turms. Jeder Turm ist detailreich gestaltet und bietet zahlreiche versteckte Überraschungen und Geheimnisse. <p>\\n\n <p>Das Set enthält auch eine Vielzahl von Figuren aus der Harry-Potter-Saga, darunter Harry Potter, Hermine Granger, Ron Weasley, Professor Dumbledore, Professor Snape, Hagrid und viele mehr. Jede Figur ist mit detaillierten Accessoires und Kostümen ausgestattet und bietet unzählige Möglichkeiten zum Spielen und Erkunden.', 'Set', 'Harry Potter',49999, 'bestseller')");
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
    public void searchRepoTest() {
        repository = new H2ProductRepository("jdbc:h2:./test", "sa", "");
        ProductService productService;
        productService = new ProductService(repository);

        List<Product> productList = productService.searchByName("Hogwards");
        Assertions.assertEquals(1 , productList.size());
        Assertions.assertEquals("Hogwards", productList.get(0).getName());
    }

}
