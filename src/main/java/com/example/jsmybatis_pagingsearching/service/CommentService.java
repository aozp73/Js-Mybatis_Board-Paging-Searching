package com.example.jsmybatis_pagingsearching.service;

import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.Exception400;
import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.Exception500;
import com.example.jsmybatis_pagingsearching.domain.BoardMapper;
import com.example.jsmybatis_pagingsearching.domain.Comment;
import com.example.jsmybatis_pagingsearching.domain.CommentMapper;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import com.example.jsmybatis_pagingsearching.web.comment.dto.CommentSave_InDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentRepoistory;
    private final BoardMapper boardRepository;

    @Transactional
    public void save(CommentSave_InDTO commentSaveInDTO, Long userId) {
        try {
            commentRepoistory.insert(commentSaveInDTO.toEntity(userId));
        } catch (Exception exception) {
            throw new Exception500("댓글 저장에 실패하였습니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<BoardDetail_OutDTO.CommentDTO> findAllForSave(Long boardId, Long userId) {
        List<BoardDetail_OutDTO.CommentDTO> commentList;
        try {   
            commentList = boardRepository.findAllWithCommentForDetail(boardId);
        } catch (Exception exception) {
            throw new Exception500("댓글 저장에 실패하였습니다."); //저장 로직에 엮임
        }
        
        return formatAndEditable(commentList, userId);
    }

    public List<BoardDetail_OutDTO.CommentDTO> formatAndEditable(List<BoardDetail_OutDTO.CommentDTO> commentList, Long userId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        commentList.forEach(commentDTO -> {
                commentDTO.setCreatedAtFormat(dateFormat.format(commentDTO.getCreatedAt()));
                if (commentDTO.getUserId().equals(userId)) {
                    commentDTO.setEditable(true);
                } else {
                    commentDTO.setEditable(false);
                }
        });


        return commentList;
    }

    @Transactional
    public void delete(Long commentId, Long userId) {
        Comment commentEntity;
        try {
            commentEntity = commentRepoistory.findById(commentId);
        } catch (Exception exception) {
            throw new Exception400("댓글이 존재하지 않습니다.");
        }

        if (!Objects.equals(commentEntity.getUserId(), userId)) {
            throw new Exception400("작성자만 삭제할 수 있습니다.");
        }

        try {
            commentRepoistory.deleteById(commentId);
        } catch (Exception exception) {
            throw new Exception500("댓글 삭제에 실패하였습니다.");
        }
    }
}
