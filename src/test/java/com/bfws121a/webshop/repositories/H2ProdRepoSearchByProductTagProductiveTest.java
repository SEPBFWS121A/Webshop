package com.bfws121a.webshop.repositories;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class H2ProdRepoSearchByProductTagProductiveTest {

    private ProductRepository repository;

    @Test
    public void searchRepoTest() {
        repository = new H2ProductRepository("jdbc:h2:./webshop", "sa", "");

        ProductService productService;
        productService = new ProductService(repository);

        List<Product> productList = productService.searchByProductTag("bestseller");
        Assertions.assertEquals(3 , productList.size());
        List<Product> productList = productService.searchByProductTag("new");
        Assertions.assertEquals(3 , productList.size());
    }

}
