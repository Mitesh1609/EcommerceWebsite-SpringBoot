package com.ecommerce.repository;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    public Product findByPid(int pid);
}
