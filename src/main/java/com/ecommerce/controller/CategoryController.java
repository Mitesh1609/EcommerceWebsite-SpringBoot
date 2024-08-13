package com.ecommerce.controller;


import com.ecommerce.DTO.CategoryDto;
import com.ecommerce.config.ApiResponse;
import com.ecommerce.entity.Category;
import com.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategory(){
        List<CategoryDto> allCategory = categoryService.getAllCategory();
        return new ResponseEntity<>(new ApiResponse(allCategory), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto category){
        CategoryDto savedCategory = categoryService.createNewCategory(category);
        return new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
    }

    @PutMapping("update/{cid}")
    public ResponseEntity<CategoryDto> updateCategoryByCid(@PathVariable Long cid, @Valid @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory = categoryService.updateCategory(cid, categoryDto);
        return new ResponseEntity<>(updatedCategory,HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{cid}")
    public ResponseEntity<String> updateCategoryByCid(@PathVariable Long cid){
        categoryService.deleteCategory(cid);
        return new ResponseEntity<>("Category deleted successfully",HttpStatus.CREATED);
    }
}
