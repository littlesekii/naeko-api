package com.littlesekii.naeko_api.pagination.seed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.littlesekii.naeko_api.pagination.enums.ProductCategory;
import com.littlesekii.naeko_api.pagination.model.Product;
import com.littlesekii.naeko_api.pagination.repository.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        
        Random random = new Random();
        int totalRecords = 1_000_000;
        int batchSize = 100_000;

        List<Product> productsBatch = new ArrayList<>();

        for (int i = 1; i <= totalRecords; i++) {
            Product p = new Product(
                "Product " + i,
                "Description for product " + i,
                random.nextDouble() * 5000,
                ProductCategory.values()[random.nextInt(ProductCategory.values().length)]
            );
            productsBatch.add(p);

            if (productsBatch.size() % batchSize == 0) {
                repository.saveAll(productsBatch);
                productsBatch.clear();
                System.out.println(i + " registers added");
            }
        }

    }
    
}
