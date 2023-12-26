package com.example.jsmybatis_pagingsearching.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;

    private String email; // 로그인
    private String password;

    private String username;

    private Timestamp createdAt;
}
