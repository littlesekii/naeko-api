package com.littlesekii.naeko_api.pagination.controller;

import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlesekii.naeko_api.pagination.model.Product;
import com.littlesekii.naeko_api.pagination.service.ProductService;


@RestController
@RequestMapping("/api/pagination/products")
public class ProductController {

    @Autowired
    ProductService service;
    
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(
        @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Product> res = service.findAll(pageable);
        return ResponseEntity.ok().body(res);
    }
    

}
