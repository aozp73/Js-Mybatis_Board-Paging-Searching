package com.example.jsmybatis_pagingsearching.service;

import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.CustomException;
import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.Exception400;
import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.Exception500;
import com.example.jsmybatis_pagingsearching.domain.Board;
import com.example.jsmybatis_pagingsearching.domain.BoardMapper;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardList_OutDTO;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardSave_InDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardRepository;

    @Transactional(readOnly = true)
    public List<BoardList_OutDTO> findAll() {
        return boardRepository.findAllWithUserForList();
    }

    @Transactional(readOnly = true)
    public BoardDetail_OutDTO findById(Long boardId) {
        BoardDetail_OutDTO boardDetailDTO = boardRepository.findAllWithUserForDetail(boardId);
        List<BoardDetail_OutDTO.CommentDTO> boardDetailCommentDTO = boardRepository.findAllWithCommentForDetail(boardId);

        return detailFormat(boardDetailDTO, boardDetailCommentDTO);
    }

    @Transactional
    public void viewsCount(Long boardId) {
        Board boardEntity;
        try {
            boardEntity = boardRepository.findById(boardId);
        } catch (Exception exception) {
            throw new CustomException("게시물이 존재하지 않습니다.");
        }
        try {
            boardEntity.setViews(boardEntity.getViews() + 1);
            boardRepository.updateById(boardEntity);
        } catch (Exception exception) {
            throw new CustomException("게시글 조회에 실패하였습니다.");
        }
    }

    public BoardDetail_OutDTO detailFormat(BoardDetail_OutDTO boardDetailDTO, List<BoardDetail_OutDTO.CommentDTO> boardDetailCommentDTO) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        // 세부 정보 날짜 포맷팅
        boardDetailDTO.setCreatedAtFormat(dateFormat.format(boardDetailDTO.getCreatedAt()));

        // 댓글 목록 날짜 포맷팅
        boardDetailCommentDTO.forEach(commentDTO ->
                commentDTO.setCreatedAtFormat(dateFormat.format(commentDTO.getCreatedAt()))
        );

        boardDetailDTO.setCommentDTO(boardDetailCommentDTO);

        return boardDetailDTO;
    }

    @Transactional
    public void save(BoardSave_InDTO boardSaveInDTO, Long userId) {
        try {
            boardRepository.insert(boardSaveInDTO.toEntity(boardSaveInDTO, userId));
        } catch (Exception exception) {
            throw new CustomException("게시글 저장에 실패하였습니다.");
        }
    }

    @Transactional
    public void delete(Long boardId, Long userId) {
        Board boardEntity;
        try {
            boardEntity = boardRepository.findById(boardId);
        } catch (Exception exception) {
            throw new Exception400("게시글이 존재하지 않습니다.");
        }

        if (!Objects.equals(boardEntity.getUserId(), userId)) {
            throw new Exception400("작성자만 삭제할 수 있습니다.");
        }

        try {
            boardRepository.deleteById(boardId);
        } catch (Exception exception) {
            throw new Exception500("게시글 삭제에 실패하였습니다.");
        }
    }
}
