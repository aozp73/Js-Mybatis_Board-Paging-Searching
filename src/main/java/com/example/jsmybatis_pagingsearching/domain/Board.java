package com.example.jsmybatis_pagingsearching.domain;

import java.sql.Timestamp;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long id;
    private Long userId;

    private String title;
    private String content;
    private Integer views;

    private Timestamp createdAt;
}
