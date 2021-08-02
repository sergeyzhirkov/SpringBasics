package com.sergeyzhirkov.market.services;

import com.sergeyzhirkov.market.model.Category;
import com.sergeyzhirkov.market.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
