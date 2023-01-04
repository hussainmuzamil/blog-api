package com.example.blogappapi.services;

import com.example.blogappapi.entity.Category;
import com.example.blogappapi.payloads.CategoryDTO;

import java.util.List;

public interface CategoryServices {
    public CategoryDTO createCategory(CategoryDTO category);
    public List<CategoryDTO> getAllCategories();
    public CategoryDTO getCategoryById(Long categoryId);
    public CategoryDTO updateCategories(CategoryDTO category,Long categoryId);
    public void deleteCategoryById(Long categoryId);

}
