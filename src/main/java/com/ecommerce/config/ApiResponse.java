package com.ecommerce.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse{
    public Object data;
    public int currentPage;
    public int totalPages;
    public int numberOfElements;
    public Long totalElements;
    public boolean lastPage;

    public ApiResponse(Object data){
        this.data = data;
    }
}
