package com.example.blogappapi.controllers;

import com.example.blogappapi.payloads.ApiResponse;
import com.example.blogappapi.payloads.CategoryDTO;
import com.example.blogappapi.services.CategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categoryDTO = categoryServices.getAllCategories();
        return ResponseEntity.ok(categoryDTO);
    }
    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("category_id") Long categoryId){
        CategoryDTO categoryDTO = categoryServices.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDTO);
    }
    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO categoryDTO1 = categoryServices.createCategory(categoryDTO);
        return ResponseEntity.ok(categoryDTO1);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,@PathVariable("id") Long categoryId){
        CategoryDTO categoryDTO1 = categoryServices.updateCategories(categoryDTO,categoryId);
        return ResponseEntity.ok(categoryDTO1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("id") Long categoryId){
        categoryServices.deleteCategoryById(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category deleted",true), HttpStatus.OK);
    }

}
