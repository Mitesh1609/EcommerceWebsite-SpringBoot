package com.ecommerce.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    public Long cid;

    @NotBlank(message = "Category name cannot be blank or null !!")
    @Size(min = 3 , message = "Category name must contain at least 3 characters")
    @Column(unique = true)
    public String categoryName;
}
