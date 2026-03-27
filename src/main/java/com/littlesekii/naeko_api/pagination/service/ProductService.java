package com.littlesekii.naeko_api.pagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.littlesekii.naeko_api.pagination.model.Product;
import com.littlesekii.naeko_api.pagination.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
}
