package com.ecommerce.service;

import com.ecommerce.DTO.CategoryDto;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CategoryRepo;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<Category> getAllCategory(int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by("categoryName"));
        return categoryRepo.findAll(pageable);
    }

    public CategoryDto createNewCategory(CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto, Category.class);
        return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    public CategoryDto updateCategory(Long cid, CategoryDto newCategory){
        Category category = categoryRepo.findByCid(cid);
        if(category != null){
            category.setCategoryName(newCategory.getCategoryName());
            categoryRepo.save(category);
        }
        else {
            throw new ResourceNotFoundException("Category","Category Id",cid);
        }
        return modelMapper.map(category, CategoryDto.class);
    }

    public void deleteCategory(Long cid){
        Category category = categoryRepo.findByCid(cid);
        if(category != null){
            categoryRepo.delete(category);
        }
        else {
            throw new ResourceNotFoundException("Category","Category Id",cid);
        }
    }
}
