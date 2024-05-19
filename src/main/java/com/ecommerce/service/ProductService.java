package com.ecommerce.service;

import com.ecommerce.entity.Product;
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

    public Product getProductById(int pid){
        Product product = productRepo.findByPid(pid);
        if(null != product) {
            return product;
        }
        else{
            throw new RuntimeException("Product does not exists!!!!! " + pid);
        }
    }

    public Product addProduct(Product product){
        Product newProd = productRepo.save(product);
        return newProd;
    }
}
