package com.example.jsmybatis_pagingsearching.web.dto;

import com.example.jsmybatis_pagingsearching.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class JoinInDTO {
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email; // 로그인

    @NotBlank(message = "패스워드를 입력해주세요.")
    @Size(min = 6, message = "6글자 이상 입력해주세요.")
    private String passwordConfirmation;
    @NotBlank(message = "패스워드 확인을 입력해주세요.")
    private String password;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 1, max = 6, message = "6글자 이내 입력해주세요.")
    private String username;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .build();
    }
}
