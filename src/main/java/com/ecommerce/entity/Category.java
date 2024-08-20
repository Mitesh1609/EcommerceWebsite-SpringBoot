package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @NotBlank(message = "Category name cannot be blank or null !!")
    @Size(min = 3 , message = "Category name must contain at least 3 characters")
    @Column(unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "productCategory")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public void setProducts(Product product) {
        List<Product> prod = this.getProducts();
        prod.add(product);
    }
}

