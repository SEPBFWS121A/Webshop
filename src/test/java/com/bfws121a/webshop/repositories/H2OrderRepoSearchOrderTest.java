package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Order;
import com.bfws121a.webshop.services.OrderService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.util.List;

@SpringBootTest
public class H2OrderRepoSearchOrderTest {

    private OrderRepository repository;
    private static String name;

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
            statement.execute("INSERT INTO orders(Adresse, Name, Kreditkartennummer, Kartenprüfnummer, Ablaufdatum) VALUES ('Musterstraße 123, 12345 Musterstadt, Deutschland','Max Mustermann', '529741836521876', '347', '02/29')");
            ResultSet tablesRS = statement.executeQuery("SELECT ID from orders");
            tablesRS.next();
            Integer orderID = tablesRS.getInt("ID");
            PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO orderedProducts(OrderID,ProduktID,Menge) VALUES (?,12345,1),(?,12346,2),(?,12347,1)");
            for(int i=1;i<4;i++){
                prepStatement.setInt(i,orderID);
            }
            prepStatement.execute();
            name = "Max Mustermann";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void kill() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement statement = conn.createStatement();
            statement.execute("delete from orders");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByProdIdTest() {
        repository = new H2OrderRepository("jdbc:h2:./test", "sa", "");
        OrderService orderService;
        orderService = new OrderService(repository);
        List<Order> orderList = orderService.orderFindByName(name);
        Assertions.assertEquals(1 , orderList.size());
    }
}
