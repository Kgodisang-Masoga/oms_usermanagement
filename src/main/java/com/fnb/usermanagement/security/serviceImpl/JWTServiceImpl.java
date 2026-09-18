package com.fnb.usermanagement.security.serviceImpl;

import com.fnb.usermanagement.security.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService {

    @Override
    public String generateToken(String email) {
        return "";
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }

    @Override
    public String extractEmailFromToken(String token) {
        return "";
    }
}
