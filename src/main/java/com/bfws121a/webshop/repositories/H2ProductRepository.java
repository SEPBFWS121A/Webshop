package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ProductRepository implements ProductRepository{
    String url;
    String user;
    String password;

    public H2ProductRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "SELECT * FROM product WHERE Name=?";
            PreparedStatement floriansMom = conn.prepareStatement(tablesQ);
            floriansMom.setString(1, name);
            ResultSet tablesRS = floriansMom.executeQuery();
            while (tablesRS.next()) {
                products.add(new Product(tablesRS.getInt("ID"),
                        tablesRS.getString("Image"),
                        tablesRS.getString("Name"),
                        tablesRS.getString("Description"),
                        tablesRS.getString("Type"),
                        tablesRS.getString("Theme"),
                        tablesRS.getInt("Price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
