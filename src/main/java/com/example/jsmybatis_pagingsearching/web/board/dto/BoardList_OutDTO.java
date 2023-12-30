package com.example.jsmybatis_pagingsearching.web.board.dto;

import com.example.jsmybatis_pagingsearching.domain.Board;
import com.example.jsmybatis_pagingsearching.util.TimeStampConverter;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardList_OutDTO {
    private Long id;
    private Long userId;

    private String title;
    private String content;
    private Integer views;

    private String createdAt;

    public static List<BoardList_OutDTO> fromEntity(List<Board> boardListEntity) {
        return boardListEntity.stream()
//                .map(board -> BoardList_OutDTO.fromBoard(board)) 
                .map(BoardList_OutDTO::fromBoard) // 축약형
                .collect(Collectors.toList());
    }

    public static BoardList_OutDTO fromBoard(Board board) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        return BoardList_OutDTO.builder()
                .id(board.getId())
                .userId(board.getUserId())
                .title(board.getTitle())
                .content(board.getContent())
                .views(board.getViews())
                .createdAt(TimeStampConverter.formatTimestamp(board.getCreatedAt(), dateFormat))
                .build();
    }
}

