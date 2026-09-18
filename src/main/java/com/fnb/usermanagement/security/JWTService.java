package com.fnb.usermanagement.security;

public interface JWTService {


    String generateToken(String email);

    boolean validateToken(String token);

    String extractEmailFromToken(String token);
}
