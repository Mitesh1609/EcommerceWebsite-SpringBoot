package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @NotBlank(message = "Category name cannot be blank or null !!")
    @Size(min = 3 , message = "Category name must contain at least 3 characters")
    private String catName;


//    @OneToMany(mappedBy = "prodCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Set<Product> catProduct;

//    public void addCatProduct(Product prod){
//        catProduct.add(prod);
//    }
}

