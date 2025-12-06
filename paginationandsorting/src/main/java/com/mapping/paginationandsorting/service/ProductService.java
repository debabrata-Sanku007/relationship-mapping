package com.mapping.paginationandsorting.service;

import com.mapping.paginationandsorting.entity.Product;
import com.mapping.paginationandsorting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Page<Product> getProducts(Pageable pageRequest) {

        return productRepository.findAll(pageRequest);
    }
}
