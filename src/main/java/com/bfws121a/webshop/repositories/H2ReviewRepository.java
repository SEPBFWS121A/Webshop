package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.object.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ReviewRepository implements ReviewRepository{

    String url;
    String user;
    String password;

    public H2ReviewRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    @Override
    public List<Review> findByProdId(int prodId) {
        List<Review> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "SELECT * FROM review WHERE ProductID=?";
            PreparedStatement floriansMom = conn.prepareStatement(tablesQ);
            floriansMom.setInt(1, prodId);
            ResultSet tablesRS = floriansMom.executeQuery();
            while (tablesRS.next()) {
                products.add(new Review(tablesRS.getInt("ID"),
                        tablesRS.getString("Publisher"),
                        tablesRS.getBoolean("Rating"),
                        tablesRS.getString("Date"),
                        tablesRS.getString("Title"),
                        tablesRS.getString("Description"),
                        tablesRS.getInt("ProductID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Review> findAll() {
        List <Review> reviews = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "SELECT * FROM review";
            Statement floriansMom = conn.createStatement();
            ResultSet tablesRS = floriansMom.executeQuery(tablesQ);
            while (tablesRS.next()) {
                reviews.add(new Review(tablesRS.getInt("id"),
                        tablesRS.getString("publisher"),
                        tablesRS.getBoolean("rating"),
                        tablesRS.getString("date"),
                        tablesRS.getString("title"),
                        tablesRS.getString("description"),
                        tablesRS.getInt("productid")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public void saveReview(Review review) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String tablesQ = "INSERT INTO review(Publisher, Rating, Date, Title, Description, ProductID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement floriansMom = conn.prepareStatement(tablesQ);
            floriansMom.setString(1, review.getPublisher());
            floriansMom.setBoolean(2, review.getRating());
            floriansMom.setString(3, review.getDate());
            floriansMom.setString(4, review.getTitle());
            floriansMom.setString(5, review.getDescription());
            floriansMom.setInt(6, review.getProductId());
            floriansMom.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
