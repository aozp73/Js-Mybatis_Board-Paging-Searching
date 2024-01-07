package com.example.jsmybatis_pagingsearching.web.board.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardList_OutDTO {
    private Long id;
    private Long userId;

    private String title;
    private Integer views;
    private String createdAtFormat;

    private Integer totalCount;

    // user_tb
    private String username;

    // commnet_tb
    private Integer commentCount;
}

