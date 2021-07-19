package com.sergeyzhirkov.market.controllers;

import com.sergeyzhirkov.market.model.Product;
import com.sergeyzhirkov.market.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("app/products/{id}")
    @ResponseBody
    public Product showProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("app/products")
    @ResponseBody
    public List<Product> showAllProducts() {
        return productService.findAll();
    }

    @GetMapping("app/products/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("app/products")
    @ResponseBody
    public Product addNewProduct(@RequestParam String name, @RequestParam Integer price) {
        return productService.addProduct(name, price);
    }
}
