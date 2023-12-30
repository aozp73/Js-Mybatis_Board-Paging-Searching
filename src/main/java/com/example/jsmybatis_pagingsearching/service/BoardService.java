package com.example.jsmybatis_pagingsearching.service;

import com.example.jsmybatis_pagingsearching.domain.BoardMapper;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardList_OutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardRepository;

    public List<BoardList_OutDTO> findAll() {

        return boardRepository.findAllForBoardList();
    }

    public BoardDetail_OutDTO findById(Long id) {
        boardRepository.findAllForBoardDetail();

        return null;
    }
}
