package com.example.jsmybatis_pagingsearching.domain;

import java.sql.Timestamp;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String email; // 로그인
    private String password;

    private String username;
    private String role;

    private Timestamp createdAt;
}
