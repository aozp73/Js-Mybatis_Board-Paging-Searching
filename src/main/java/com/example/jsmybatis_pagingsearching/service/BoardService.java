package com.example.jsmybatis_pagingsearching.service;

import com.example.jsmybatis_pagingsearching.domain.BoardMapper;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardList_OutDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardRepository;

    public List<BoardList_OutDTO> findAll() {

        return boardRepository.findAllWithUserForList();
    }

    public BoardDetail_OutDTO findById(Long boardId) {
        BoardDetail_OutDTO boardDetailDTO = boardRepository.findAllWithUserForDetail(boardId);
        List<BoardDetail_OutDTO.CommentDTO> boardDetailCommentDTO = boardRepository.findAllWithCommentForDetail(boardId);

        return detailFormat(boardDetailDTO, boardDetailCommentDTO);
    }

    public BoardDetail_OutDTO detailFormat(BoardDetail_OutDTO boardDetailDTO, List<BoardDetail_OutDTO.CommentDTO> boardDetailCommentDTO) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 세부 정보 날짜 포맷팅
        boardDetailDTO.setCreatedAtFormat(dateFormat.format(boardDetailDTO.getCreatedAt()));

        // 댓글 목록 날짜 포맷팅
        boardDetailCommentDTO.forEach(commentDTO ->
                commentDTO.setCreatedAtFormat(dateFormat.format(commentDTO.getCreatedAt()))
        );

        boardDetailDTO.setCommentDTO(boardDetailCommentDTO);

        return boardDetailDTO;
    }
}
