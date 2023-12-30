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
    
    // user_tb 필드
    private String username;

//    private Timestamp createdAt;
    private String createdAtFormat;

//    public static List<BoardList_OutDTO> fromEntity(List<Board> boardListEntity) {
//        return boardListEntity.stream()
////                .map(board -> BoardList_OutDTO.fromBoard(board)) 
//                .map(BoardList_OutDTO::fromBoard) // 축약형
//                .collect(Collectors.toList());
//    }
//
//    public static BoardList_OutDTO fromBoard(Board board) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//
//        return BoardList_OutDTO.builder()
//                .id(board.getId())
//                .userId(board.getUserId())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .views(board.getViews())
//                .createdAt(TimeStampConverter.formatTimestamp(board.getCreatedAt(), dateFormat))
//                .build();
//    }
}

