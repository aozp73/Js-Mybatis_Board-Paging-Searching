package com.example.jsmybatis_pagingsearching.web.board.dto;

import com.example.jsmybatis_pagingsearching.domain.Board;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardUpdate_OutDTO {

    private Long id;
    private Long userId;
    private String title;
    private String content;

    public BoardUpdate_OutDTO fromEntity(Board boardEntity) {
        return BoardUpdate_OutDTO.builder()
                .id(boardEntity.getId())
                .userId(boardEntity.getUserId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .build();
    }
}
