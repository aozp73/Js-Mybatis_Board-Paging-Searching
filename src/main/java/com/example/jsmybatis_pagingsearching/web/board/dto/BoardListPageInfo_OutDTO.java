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
    Integer totalCount;

    Integer totalPage;
    Integer currentPage;

    Integer startPage;
    Integer endPage;

    @Builder.Default
    Boolean isFirst = false;
    @Builder.Default
    Boolean isLast = false;

    public void pageCalculate(Integer totalCount, Integer currentPage) {
        this.totalCount = totalCount;
        this.currentPage = currentPage - 1;

        Integer tmp = this.currentPage / BUTTONCOUNT;
        this.totalPage = (int) Math.ceil((double) totalCount / ROW);
        this.startPage = 1 + (tmp * BUTTONCOUNT);
        this.endPage = 5 + (tmp * BUTTONCOUNT);

        if (totalPage < endPage) {
            this.endPage = totalPage;
        }

        if (currentPage == 1) {
            this.isFirst = true;
        }
        if (currentPage.equals(totalPage)) {
            this.isLast = true;
        }
    }
}
