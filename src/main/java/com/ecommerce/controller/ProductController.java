package com.ecommerce.controller;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> allProd = productService.getAllProductDetails();
        return new ResponseEntity<>(allProd, HttpStatus.OK);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<Product> getProduct(@PathVariable int pid){
        Product product = productService.getProductById(pid);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
