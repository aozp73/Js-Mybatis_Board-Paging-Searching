package com.example.jsmybatis_pagingsearching.web.board.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDetail_OutDTO {
    private Long id;
    private Long userId;

    private String title;
    private String content;
    private Integer views;
    private Timestamp createdAt;
    private String createdAtFormat;

    // user_tb
    private String username;

    // commnet_tb
    private Integer commentCount;

    private List<CommentDTO> commentDTO;
    @Getter
    @Setter
    @ToString
    public static class CommentDTO {
        private Long id;
        private Long userId;
        private String username;
        private String content;
        private Timestamp createdAt;
        private String createdAtFormat;

    }
}
