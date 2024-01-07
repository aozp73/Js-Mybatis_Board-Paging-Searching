package com.example.jsmybatis_pagingsearching.web.board.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardListSearch_InDTO {

    private String searchType;
    private String searchKeyword;
    private Integer page;
}
