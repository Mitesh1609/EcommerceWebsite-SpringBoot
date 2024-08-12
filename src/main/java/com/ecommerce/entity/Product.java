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
    private Long pid;

    private String prodName;

    private String prodDesc;

    private Double prodPrice;

//    @ManyToOne
//    @JoinColumn(name = "cid")
//    private Category prodCategory;
}
