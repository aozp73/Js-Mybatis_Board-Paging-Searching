package com.example.jsmybatis_pagingsearching.domain;

import java.util.List;

import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardList_OutDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public Integer insert(Board board);

    public List<Board> findAll();

    public List<BoardList_OutDTO> findAllForBoardList();

    public List<BoardDetail_OutDTO> findAllForBoardDetail();

    public Board findById(Long id);

    public Integer updateById(Board board);

    public Integer deleteById(Long id);
}
