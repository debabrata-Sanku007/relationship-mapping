package com.mapping.paginationandsorting.controller;

import com.mapping.paginationandsorting.entity.Product;
import com.mapping.paginationandsorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class PaginationAndSortingController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> getProduct(@RequestParam(required = false, defaultValue = "0") int pageNumber,
                                                    @RequestParam(required = false, defaultValue = "5") int pageSize,
                                                    @RequestParam(required = false, defaultValue = "id") String sortByField,
                                                    @RequestParam(required = false, defaultValue = "asc") String direction
    ) {
        Sort sort = null;
        if (direction == null || direction.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortByField).ascending();
        } else {
            sort = Sort.by(sortByField).descending();
        }
        Page<Product> products = productService.getProducts(PageRequest.of(pageNumber, pageSize, sort));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
