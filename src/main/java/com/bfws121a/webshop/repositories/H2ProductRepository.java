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
        PreparedStatement floriansMom = null;

        List<Product> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "SELECT * FROM product WHERE Name=?";
            floriansMom = conn.prepareStatement(tablesQ);
            floriansMom.setString(1, name);
            ResultSet tablesRS = floriansMom.executeQuery();
            while (tablesRS.next()) {
                products.add(new Product(tablesRS.getInt("ID"),
                        tablesRS.getString("Image"),
                        tablesRS.getString("Name"),
                        tablesRS.getString("Description"),
                        tablesRS.getString("Type"),
                        tablesRS.getString("Theme"),
                        tablesRS.getInt("Price"),
                        tablesRS.getString("producttags")));
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert floriansMom != null;
                floriansMom.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public List<Product> findAll() {
        Statement floriansMom = null;

        List<Product> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "SELECT * FROM product";
            floriansMom = conn.createStatement();
            ResultSet tablesRS = floriansMom.executeQuery(tablesQ);
            while (tablesRS.next()) {
                products.add(new Product(tablesRS.getInt("ID"),
                        tablesRS.getString("Image"),
                        tablesRS.getString("Name"),
                        tablesRS.getString("Description"),
                        tablesRS.getString("Type"),
                        tablesRS.getString("Theme"),
                        tablesRS.getInt("Price"),
                        tablesRS.getString("producttags")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert floriansMom != null;
                floriansMom.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public void deleteByName(String name) {
        PreparedStatement floriansMom = null;

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "DELETE FROM product WHERE Name=?";
            floriansMom = conn.prepareStatement(tablesQ);
            floriansMom.setString(1, name);
            floriansMom.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert floriansMom != null;
                floriansMom.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
