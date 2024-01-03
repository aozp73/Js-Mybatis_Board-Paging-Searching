package com.example.jsmybatis_pagingsearching.service;

import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.CustomException;
import com.example.jsmybatis_pagingsearching.domain.Comment;
import com.example.jsmybatis_pagingsearching.domain.CommentMapper;
import com.example.jsmybatis_pagingsearching.web.comment.dto.CommentSave_InDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentRepoistory;

    @Transactional
    public void save(CommentSave_InDTO commentSaveInDTO, Long userId) {
        try {
            commentRepoistory.insert(commentSaveInDTO.toEntity(userId));
        } catch (Exception exception) {
            throw new CustomException("댓글 저장에 실패하였습니다.");
        }

    }
}
