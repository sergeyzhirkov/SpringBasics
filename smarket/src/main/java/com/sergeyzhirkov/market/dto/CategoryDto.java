package com.sergeyzhirkov.market.dto;

import com.sergeyzhirkov.market.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private String listProducts;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.listProducts = category.getProducts().stream()
                .map(ProductDto::new)
                .map(ProductDto::getTitle)
                .collect(Collectors.toList()).toString();
    }
}
