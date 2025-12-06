package com.mapping.paginationandsorting;

import com.mapping.paginationandsorting.entity.Product;
import com.mapping.paginationandsorting.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class PaginationAndSortingApplication {

    private final ProductRepository productRepository;

    public PaginationAndSortingApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PaginationAndSortingApplication.class, args);
    }

    //@PostConstruct
    public void saveProduct() {
        IntStream.range(0, 500).
                mapToObj(m -> new Product(m, "Product_" + m, new Random().nextInt(1000, 10000), new Random().nextInt(1, 500)))
                .forEach(productRepository::save);
    }

}
