package com.fnb.usermanagement.security;

import com.fnb.usermanagement.entity.User;

public interface JWTService {


    String generateToken(User user);

    boolean validateToken(String token, String email);

    String extractEmailFromToken(String token);
}
