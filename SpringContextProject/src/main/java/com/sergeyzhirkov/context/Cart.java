package com.sergeyzhirkov.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> products;
    private ProductRepository productRepository;

    @Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void createListProducts() {
        products = new ArrayList<>();
    }

    public void addProductById(int id) {
        Optional<Product> product = productRepository.getProductById(id);
        if (product.isPresent()) {
            products.add(product.get());
        }
    }

    public void removeProductById(int id) {
        Optional<Product> product = productRepository.getProductById(id);
        if (product.isPresent()) {
            products.remove(product.get());
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
