package com.ecommerce.entity;

import lombok.Data;

@Data
public class JwtAuthRequest {

    public String username;

    public String password;
}
