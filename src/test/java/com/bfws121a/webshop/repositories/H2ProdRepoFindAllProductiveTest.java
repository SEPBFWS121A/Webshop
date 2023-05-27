package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class H2ProdRepoFindAllProductiveTest {

    private H2ProductRepository repository;

    @Test
    public void findAllTest () {
        repository = new H2ProductRepository("jdbc:h2:./webshop", "sa", "");

        ProductService productService;
        productService = new ProductService(repository);
        List<Product> productList = productService.findAll();

        System.out.println("\n");
        for (Product product : productList) {
            System.out.println(product.toString() + "\n");
        }

        Assertions.assertEquals(9, productList.size());
    }

}
