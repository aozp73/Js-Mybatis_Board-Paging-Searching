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
    private String content;
    private Integer views;

    // user_tb
    private String username;

    // commnet_tb
    private Integer commentCount;

//    private Timestamp createdAt;
    private String createdAtFormat;

}

