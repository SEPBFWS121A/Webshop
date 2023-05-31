package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Review;
import com.bfws121a.webshop.services.ProductService;
import com.bfws121a.webshop.services.ReviewService;
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
public class H2ReviewRepoAddOrderTest {

    private ReviewRepository repository;
    private static String name;
    private static Order order;

    @BeforeAll
    public static void setup() {


        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement floriansMom = conn.createStatement();
            floriansMom.execute("CREATE TABLE IF NOT EXISTS orders (\n" +
                    "    ID int primary key auto_increment,\n" +
                    "    Adresse varchar(256),\n" +
                    "    Name varchar(256),\n" +
                    "    Kreditkartennummer varchar(256),\n" +
                    "    Kartenprüfnummer varchar(256),\n" +
                    "    Ablaufdatum character varying,\n" +
                    ");");
            floriansMom.execute("CREATE TABLE IF NOT EXISTS orderedProducts (\n" +
                    "    OrderID int,\n" +
                    "    ProductID int ,\n" +
                    "    Amount int,\n" +
                    "primary key(OrderId,ProcuctID) \n" +
                    "foreign key (OrderID) references orders(ID)" +
                    ");");
            name = "Max Mustermann";
            order = new Order("Musterstraße 123, 12345 Musterstadt, Deutschland","Max Mustermann", "529741836521876", "347", "02/29", List.of(12345,12346,12347), List.of(1,2,1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void kill() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement floriansMom = conn.createStatement();
            floriansMom.execute("delete from order");
            floriansMom.execute("delete from orderedProducts");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByProdIdTest() {
        repository = new H2OrderRepository("jdbc:h2:./test", "sa", "");
        OrderService orderService;
        orderService = new OrderService(repository);

        orderService.save(order);
        List<Order> orderList = orderService.orderFindByName(name);
        Assertions.assertEquals(1 , orderList.size());
    }
}
