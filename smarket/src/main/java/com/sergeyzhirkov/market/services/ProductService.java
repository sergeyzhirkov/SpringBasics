package com.sergeyzhirkov.market.services;

import com.sergeyzhirkov.market.model.Product;
import com.sergeyzhirkov.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.getAssortiment();
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
