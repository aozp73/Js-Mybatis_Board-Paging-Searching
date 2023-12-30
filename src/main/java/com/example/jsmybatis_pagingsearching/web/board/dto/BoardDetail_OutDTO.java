package com.example.jsmybatis_pagingsearching.web.board.dto;

import lombok.*;

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
    private String createdAtFormat;

    // user_tb
    private String username;

    // commnet_tb
    private Integer commentCount;

    @Getter
    @Setter
    public static class CommentDTO {
        private Long id;
        private Long commentUsername;
        private Long commentContent;
        private Long commentCreatedAtFormat;
    }
}
