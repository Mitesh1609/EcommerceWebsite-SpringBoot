package com.ecommerce.controller;


import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> allCategory = categoryService.getAllCategory();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
        Category savedCategory = categoryService.createNewCategory(category);
        return new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
    }

    @PutMapping("update/{cid}")
    public ResponseEntity<Category> updateCategoryByCid(@PathVariable Long cid, @RequestParam String categoryName){
        Category updatedCategory = categoryService.updateCategory(cid, categoryName);
        return new ResponseEntity<>(updatedCategory,HttpStatus.CREATED);
    }
}
