package com.example.jsmybatis_pagingsearching.web.comment.dto;

import com.example.jsmybatis_pagingsearching.domain.Comment;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentSave_InDTO {

    private Long boardId;
    private String content;

    public Comment toEntity(Long userId) {
        return Comment.builder()
                .userId(userId)
                .boardId(this.boardId)
                .content(this.content)
                .build();
    }
}
