// src/main/java/com/mentorship/platform/dto/LoginRequest.java
package com.mentorship.platform.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}