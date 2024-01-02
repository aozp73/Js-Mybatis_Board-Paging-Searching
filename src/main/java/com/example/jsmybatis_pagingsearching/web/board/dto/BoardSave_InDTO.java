package com.example.jsmybatis_pagingsearching.web.board.dto;

import com.example.jsmybatis_pagingsearching.domain.Board;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardSave_InDTO {

    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 30, message = "제목을 30자 이내로 작성해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    public Board toEntity(BoardSave_InDTO boardSaveInDTO, Long userId) {
        return Board.builder()
                .userId(userId)
                .title(boardSaveInDTO.getTitle())
                .content(boardSaveInDTO.getContent())
                .views(0)
                .build();
    }
}
