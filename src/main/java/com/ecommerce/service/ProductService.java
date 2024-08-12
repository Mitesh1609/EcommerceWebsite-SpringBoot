package com.ecommerce.service;

import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProductDetails(){
        return productRepo.findAll();
    }

    public Product getProductById(Long pid){
        Product product = productRepo.findByPid(pid);
        if(null != product) {
            return product;
        }
        else{
            throw new ResourceNotFoundException("Product","pid",pid);
        }
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }
}
