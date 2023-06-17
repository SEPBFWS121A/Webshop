package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2OrderRepository implements OrderRepository{

    String url;
    String user;
    String password;

    public H2OrderRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    @Override
    public List<Order> findByName(String name) {
        List<Order> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "SELECT * FROM orders WHERE name=?";
            PreparedStatement statement = conn.prepareStatement(tablesQ);
            statement.setString(1, name);
            ResultSet tablesRS = statement.executeQuery();
            while (tablesRS.next()) {
                Integer orderID = tablesRS.getInt("ID");
                tablesQ = "SELECT * FROM orderedProducts WHERE OrderID=?";
                statement = conn.prepareStatement(tablesQ);
                statement.setInt(1,orderID);
                ResultSet tablesRS2 = statement.executeQuery();
                List<Integer> productIDs = new ArrayList<>();
                List<Integer> amounts = new ArrayList<>();
                while (tablesRS2.next()){
                    productIDs.add(tablesRS2.getInt("OrderID"));
                    amounts.add(tablesRS2.getInt("Menge"));
                }
                products.add(new Order(orderID,
                        tablesRS.getString("Adresse"),
                        tablesRS.getString("Name"),
                        tablesRS.getString("Kreditkartennummer"),
                        tablesRS.getString("Kartenprüfnummer"),
                        tablesRS.getString("Ablaufdatum"),
                        productIDs,
                        amounts));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void save(Order order) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "INSERT INTO orders(Adresse, Name, Kreditkartennummer, Kartenprüfnummer, Ablaufdatum) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(tablesQ);
            statement.setString(1, order.getAddress());
            statement.setString(2, order.getName());
            statement.setString(3, order.getCreditCardNumber());
            statement.setString(4, order.getCheckDigit());
            statement.setString(5, order.getExpiryDate());
            statement.execute();

            tablesQ = "SELECT MAX(ID) AS lastID FROM orders";
            statement = conn.prepareStatement(tablesQ);
            ResultSet tablesRS = statement.executeQuery();
            tablesRS.next();
            Integer orderID = tablesRS.getInt("lastID");

            List<Integer> productIDs = order.getProductIDs();
            List<Integer> amounts = order.getAmounts();
            tablesQ = "INSERT INTO orderedProducts(OrderID,ProduktID,Menge) VALUES (?,?,?)";
            statement = conn.prepareStatement(tablesQ);
            for(int i = 0; i< productIDs.size();i++){
                statement.setInt(1,orderID);
                statement.setInt(2,productIDs.get(i));
                statement.setInt(3,amounts.get(i));
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
