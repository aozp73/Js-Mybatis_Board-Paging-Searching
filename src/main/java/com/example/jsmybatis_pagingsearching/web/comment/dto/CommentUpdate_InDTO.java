package com.example.jsmybatis_pagingsearching.web.comment.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentUpdate_InDTO {

    private String content;
    private Long boardId;
    private Long commentId;
}
