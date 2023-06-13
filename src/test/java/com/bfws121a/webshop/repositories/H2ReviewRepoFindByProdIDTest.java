package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Review;
import com.bfws121a.webshop.services.ProductService;
import com.bfws121a.webshop.services.ReviewService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.util.List;

@SpringBootTest
public class H2ReviewRepoFindByProdIDTest {

    private ReviewRepository repository;
    private static ProductRepository productRepository;
    private static ProductService productService;
    private static int prodId;

    @BeforeAll
    public static void setup() {
        productRepository = new H2ProductRepository("jdbc:h2:./test", "sa", "");
        productService = new ProductService(productRepository);


        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement floriansMom = conn.createStatement();
            //floriansMom.execute("Drop TABLE  IF EXISTS review");
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
            floriansMom.execute("CREATE TABLE IF NOT EXISTS review (\n" +
                    "    ID int primary key auto_increment,\n" +
                    "    Publisher varchar(256),\n" +
                    "    Rating Boolean,\n" +
                    "    Date varchar(256),\n" +
                    "    Title varchar(256),\n" +
                    "    Description character varying,\n" +
                    "    ProductID int,\n" +
                    "    foreign key (ProductID) references product(ID) on delete Cascade\n" +
                    ");");
            //floriansMom.executeQuery("select * from COLUMNS");
            floriansMom.execute("INSERT INTO product(Image, Name, Description, Type, Theme, Price) VALUES ('icons/Hogwards.png', 'Hogwards', 'Erlebe die Magie von Hogwards mit diesem atemberaubenden Baustein Set! Das Set umfasst die berühmte Schule für Hexerei und Zauberei in all ihrer majestätischen Pracht.<p>\n\n<p>Das Set enthält die verschiedenen Türme und Gebäude von Hogwarts, einschließlich des Uhrturms, der Eulerei und des Gryffindor-Turms. Jeder Turm ist detailreich gestaltet und bietet zahlreiche versteckte Überraschungen und Geheimnisse. <p>\\n\n <p>Das Set enthält auch eine Vielzahl von Figuren aus der Harry-Potter-Saga, darunter Harry Potter, Hermine Granger, Ron Weasley, Professor Dumbledore, Professor Snape, Hagrid und viele mehr. Jede Figur ist mit detaillierten Accessoires und Kostümen ausgestattet und bietet unzählige Möglichkeiten zum Spielen und Erkunden.', 'Set', 'Harry Potter',49999)");
            prodId = productService.searchByName("Hogwards").get(0).getId();
            String tablesQ = "INSERT INTO review(Publisher, Rating, Date, Title, Description, ProductID) VALUES ('Max Mustermann', true, '08.04.2023','Tolles Produkt', 'Tolles Produkt, gerne wieder!', ?)";
            PreparedStatement floriansDad = conn.prepareStatement(tablesQ);
            floriansDad.setInt(1, prodId);
            floriansDad.execute();
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
    public void searchByProdIdTest() {
        repository = new H2ReviewRepository("jdbc:h2:./test", "sa", "");
        ReviewService reviewService;
        reviewService = new ReviewService(repository);

        List<Review> reviewList = reviewService.findByProdId(prodId);
        Assertions.assertEquals(1 , reviewList.size());

    }
}
