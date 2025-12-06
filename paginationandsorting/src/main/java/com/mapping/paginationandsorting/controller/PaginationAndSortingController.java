package com.mapping.paginationandsorting.controller;

import com.mapping.paginationandsorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class PaginationAndSortingController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public 


}
