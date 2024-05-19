package com.ecommerce.JWT;

import com.ecommerce.entity.User;
import lombok.Data;

@Data
public class JwtAuthResponse {
    private String token;
    private User user;
}
