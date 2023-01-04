package com.example.blogappapi.services;

import com.example.blogappapi.entity.Category;
import com.example.blogappapi.entity.User;
import com.example.blogappapi.exceptions.ResourceNotFoundException;
import com.example.blogappapi.payloads.CategoryDTO;
import com.example.blogappapi.payloads.UserDTO;
import com.example.blogappapi.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServicesImplementation implements CategoryServices{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO category) {
        Category map = this.modelMapper.map(category, Category.class);
        Category category1= this.categoryRepository.save(map);
        return this.modelMapper.map(category1,CategoryDTO.class);

    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category:
                categories) {
            categoryDTOS.add(this.modelMapper.map(category,CategoryDTO.class));
        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
        return this.modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategories(CategoryDTO category, Long categoryId) {
        Category category1 = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","id",categoryId));
        category1.setCategoryTitle(category.getCategoryTitle());
        category1.setCategoryDescription(category.getCategoryDescription());
        Category savedCategory = categoryRepository.save(category1);
        return this.modelMapper.map(savedCategory,CategoryDTO.class);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
        this.categoryRepository.delete(category);
    }
}
