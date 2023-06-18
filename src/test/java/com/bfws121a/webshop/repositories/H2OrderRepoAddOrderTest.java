package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Order;
import com.bfws121a.webshop.services.OrderService;
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

    private OrderRepository repository;
    private static String name;
    private static Order order;

    @BeforeAll
    public static void setup() {


        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement statement = conn.createStatement();
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS orders (
                    ID int primary key auto_increment,
                    Adresse varchar(256),
                    Name varchar(256),
                    Kreditkartennummer varchar(256),
                    Kartenprüfnummer varchar(256),
                    Ablaufdatum varchar(256)
                    );""");
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS orderedProducts(
                    OrderID int,
                    ProduktID int,
                    Menge int,
                    primary key(OrderID,ProduktID),
                    foreign key(OrderID) references orders(ID) on delete cascade
                    );""");
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
            floriansMom.execute("delete from orders");
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
        if(orderList.size()>=1){
            Order firtsOrder = orderList.get(0);
            Assertions.assertEquals(3,firtsOrder.getProductIDs().size());
        }
    }
}
