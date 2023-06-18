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

//BY Robin
@SpringBootTest
public class H2ProdAddByNameTest {

    private H2ProductRepository repository;

    @BeforeAll
    public static void setup() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS product (\n" +
                    "    ID int primary key auto_increment,\n" +
                    "    Image varchar(256),\n" +
                    "    Name character varying,\n" +
                    "    Description character varying,\n" +
                    "    Type varchar(256),\n" +
                    "    Theme varchar(256),\n" +
                    "    Price int,\n" +
                    "    producttags varchar(255)\n" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void cleanup() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM product");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addByNameTest() {
        repository = new H2ProductRepository("jdbc:h2:./test", "sa", "");
        ProductService productService = new ProductService(repository);
        
        Product newProduct = new Product();
        newProduct.setImage("icons/NewProduct.png");
        newProduct.setName("New Product");
        newProduct.setDescription("This is a new product");
        newProduct.setType("Type");
        newProduct.setTheme("Theme");
        newProduct.setPrice(999);
        newProduct.setProductTags("new, featured");
        
        productService.addProduct(newProduct);
        
        List<Product> productList = productService.findAll();

        Assertions.assertEquals(1, productList.size());
        Assertions.assertEquals("New Product", productList.get(0).getName());
    }
}
