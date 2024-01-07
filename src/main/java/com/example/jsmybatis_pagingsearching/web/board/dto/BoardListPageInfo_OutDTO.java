package com.example.jsmybatis_pagingsearching.web.board.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardListPageInfo_OutDTO {
    public static final int ROW = 5; // 한 페이지 게시물 수
    public static final int BUTTONCOUNT = 5; // 1-5, 6-10 구분

    Integer totalPage;
    Integer currentPage;

    Integer startPage;
    Integer endPage;

    Boolean isFirst = false;
    Boolean isLast = false;

    public void pageCalculate(Integer totalPage, Integer currentPage) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;

        Integer tmp = currentPage / BUTTONCOUNT;
        this.startPage = 1 + (tmp * BUTTONCOUNT);
        this.endPage = 5 + (tmp * BUTTONCOUNT);

        if (currentPage == 1) {
            this.isFirst = true;
        }

        if (currentPage == totalPage - 1) {
            this.isLast = true;
        }
    }
}
