package com.mapping.paginationandsorting.service;

import com.mapping.paginationandsorting.entity.Product;
import com.mapping.paginationandsorting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveQuestion(Product question) {
        return productRepository.save(question);

    }

    public Optional<Product> getQuestion(int id) {
        return productRepository.findById(id);
    }
}
