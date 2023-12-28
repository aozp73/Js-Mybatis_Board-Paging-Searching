package com.example.jsmybatis_pagingsearching.web.dto;

import com.example.jsmybatis_pagingsearching.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinInDTO {
    Long id;
    String email;
    String password;
    String username;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .build();
    }
}
