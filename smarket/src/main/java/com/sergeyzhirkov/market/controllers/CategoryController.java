package com.sergeyzhirkov.market.controllers;

import com.sergeyzhirkov.market.dto.CategoryDto;
import com.sergeyzhirkov.market.model.Category;
import com.sergeyzhirkov.market.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return new CategoryDto(categoryService.findById(id));
    }
}
