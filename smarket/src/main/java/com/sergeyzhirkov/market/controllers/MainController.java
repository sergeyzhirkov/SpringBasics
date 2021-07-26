package com.sergeyzhirkov.market.controllers;

import com.sergeyzhirkov.market.model.Product;
import com.sergeyzhirkov.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    private ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/nav")
//    public String showNavigation() {
//        return "nav";
//    }
//
//    @GetMapping("/all")
//    public String showAllProducts(Model model) {
//        List<Product> products = productService.findAll();
//        model.addAttribute("products", products);
//        return "all_products";
//    }
//
//    @GetMapping("/create_product_form")
//    public String showCreateProductForm() {
//        return "add_form";
//    }
////
////    @PostMapping("/create_new_product")
////    public String createNewProduct(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer price) {
////        productService.addProduct(new Product(id, name, price));
////        return "redirect:/all";
////    }
//
//    @GetMapping("/product/{id}")
//    public String productInfo(Model model, @PathVariable int id) {
//        model.addAttribute("product", productService.getProductById(id));
//        return "product_info";
//    }
}
