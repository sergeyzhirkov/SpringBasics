package com.sergeyzhirkov.market.services;

import com.sergeyzhirkov.market.model.Product;
import com.sergeyzhirkov.market.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product addProduct(String name, Integer price) {
        Product product = new Product();
        if (price < 0) {
            return product;
        }
        product.setName(name);
        product.setPrice(price);
        return productRepository.save(product);
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
