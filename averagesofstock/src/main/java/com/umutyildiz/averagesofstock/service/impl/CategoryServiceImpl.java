package com.umutyildiz.averagesofstock.service.impl;

import com.umutyildiz.averagesofstock.entity.Category;
import com.umutyildiz.averagesofstock.repository.CategoryRepository;
import com.umutyildiz.averagesofstock.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }
}
