package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private String productDesc;

    private Double productPrice;

    private Long productQuantity;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category productCategory;
}
