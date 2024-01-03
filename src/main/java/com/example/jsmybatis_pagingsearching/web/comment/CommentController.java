package com.example.jsmybatis_pagingsearching.web.comment;

import com.example.jsmybatis_pagingsearching.advice.exception.ResponseDTO;
import com.example.jsmybatis_pagingsearching.config.security.principal.MyUserDetails;
import com.example.jsmybatis_pagingsearching.service.CommentService;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import com.example.jsmybatis_pagingsearching.web.comment.dto.CommentSave_InDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/auth/comment")
    public ResponseEntity<?> save(@RequestBody CommentSave_InDTO commentSaveInDTO, @AuthenticationPrincipal MyUserDetails myUserDetails) {
        log.debug("POST - 댓글 작성");
        commentService.save(commentSaveInDTO, myUserDetails.getUser().getId());
        List<BoardDetail_OutDTO.CommentDTO> commentList = commentService.findAllForSave(commentSaveInDTO.getBoardId(), myUserDetails.getUser().getId());

        return ResponseEntity.ok().body(new ResponseDTO<>().data(commentList));
    }
}
