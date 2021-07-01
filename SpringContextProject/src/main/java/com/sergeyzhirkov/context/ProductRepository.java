package com.sergeyzhirkov.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> assortiment;

    public List<Product> getAssortiment() {
        return assortiment;
    }

    public Optional<Product> getProductById(int id) {
        return assortiment.stream()
                .filter(x -> x.getId() == id)
                .findAny();
    }

    @PostConstruct
    public void init() {
        assortiment = new ArrayList<Product>();
        assortiment.add(new Product(1, "milk", 100));
        assortiment.add(new Product(2, "water", 20));
        assortiment.add(new Product(3, "juice", 50));
        assortiment.add(new Product(4, "bread", 40));
        assortiment.add(new Product(5, "pasta", 80));
    }
}
