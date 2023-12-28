package com.example.jsmybatis_pagingsearching.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Comment {
    private Long id;
    private Long userId;
    private Long boardId;

    private String content;

    private Timestamp createdAt;
}
