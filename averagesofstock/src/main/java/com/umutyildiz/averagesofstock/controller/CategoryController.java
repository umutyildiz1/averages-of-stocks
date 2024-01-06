package com.umutyildiz.averagesofstock.controller;

import com.umutyildiz.averagesofstock.entity.Category;
import com.umutyildiz.averagesofstock.utility.dto.CategoryDto;
import com.umutyildiz.averagesofstock.service.CategoryService;
import com.umutyildiz.averagesofstock.utility.mapper.CategoryMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<CategoryDto> getCategoryList(){
        List<Category> categoryList = categoryService.getCategoryList();
        List<CategoryDto> dtoList = new ArrayList<>();
        if(categoryList.isEmpty())
            return null;

        for(Category c : categoryService.getCategoryList()){
            dtoList.add(mapToDto(c));
        }
        return dtoList;
    }

    private CategoryDto mapToDto(Category category){
        return CategoryMapper.mapper.entityToDto(category);
    }
}
