package com.example.jsmybatis_pagingsearching.domain;

import java.util.List;

import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardList_OutDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public Integer insert(Board board);

    public List<Board> findAll();

    // 게시판 목록
    public List<BoardList_OutDTO> findAllWithUserForList();

    // 게시판 상세
    public BoardDetail_OutDTO findAllWithUserForDetail(Long boardId);
    public List<BoardDetail_OutDTO.CommentDTO> findAllWithCommentForDetail(Long boardId);

    public Board findById(Long id);

    public Integer updateById(Board board);

    public Integer deleteById(Long id);
}
