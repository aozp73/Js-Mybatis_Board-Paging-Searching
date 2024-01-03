package com.example.jsmybatis_pagingsearching.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long userId;
    private Long boardId;

    private String content;

    private Timestamp createdAt;
}
