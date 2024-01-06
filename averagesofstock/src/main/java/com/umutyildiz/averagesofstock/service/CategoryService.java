package com.umutyildiz.averagesofstock.service;

import com.umutyildiz.averagesofstock.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList();
    Category getCategoryByName(String name);
}
