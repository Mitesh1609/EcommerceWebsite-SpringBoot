package com.ecommerce.service;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

//    public Set<Product> getAllProductByCategoryId(int cid){
//        return categoryRepo.findByCid(cid).getCatProduct();
//    }

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    public Category createNewCategory(Category category){
        return categoryRepo.save(category);
    }

    public Category updateCategory(Long cid, String categoryName){
        Category category = categoryRepo.findByCid(cid);
        if(category != null){
            category.setCatName(categoryName);
        }
        else {
            throw new ResourceNotFoundException("Category","Category Id",cid);
        }
        return category;
    }
}
