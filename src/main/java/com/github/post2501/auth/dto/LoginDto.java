package com.github.post2501.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {
    // 로그인 DTO
    private String email;
    private String password;
}
