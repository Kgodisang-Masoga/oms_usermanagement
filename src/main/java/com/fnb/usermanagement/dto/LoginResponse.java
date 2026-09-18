package com.fnb.usermanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private String token;
    private long customerId;
    private String email;
    private String role;
}
