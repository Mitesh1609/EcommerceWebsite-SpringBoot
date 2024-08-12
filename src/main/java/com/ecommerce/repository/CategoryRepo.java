package com.ecommerce.repository;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {

    public Category findByCid(int cid);

//    @Query("SELECT c FROM category c LEFT JOIN FETCH c.product")
//    public List<Category> findAllWithProducts();
}
