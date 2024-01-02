package com.example.jsmybatis_pagingsearching.web.board.dto;

import com.example.jsmybatis_pagingsearching.domain.Board;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardUpdate_InDTO {

    private Long id;
    private String title;
    private String content;

    public Board toEntity(Board boardEntity) {
        boardEntity.setTitle(this.title);
        boardEntity.setContent(this.content);
        
        return boardEntity;
    }
}
