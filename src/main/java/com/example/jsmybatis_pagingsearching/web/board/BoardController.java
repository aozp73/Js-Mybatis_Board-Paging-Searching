package com.example.jsmybatis_pagingsearching.web.board;

import com.example.jsmybatis_pagingsearching.advice.exception.ResponseDTO;
import com.example.jsmybatis_pagingsearching.config.security.principal.MyUserDetails;
import com.example.jsmybatis_pagingsearching.service.BoardService;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardSave_InDTO;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardUpdate_OutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String list(Model model) {
        log.debug("GET - 게시글 목록 페이지");
        model.addAttribute("boardList", boardService.findAll());

        return "pages/board/list";
    }
    
    @GetMapping("/board/{boardId}")
    public String detail(@PathVariable Long boardId, Model model) {
        log.debug("GET - 게시글 상세 페이지");
        boardService.viewsCount(boardId);
        model.addAttribute("boardList", boardService.findById(boardId));

        return "pages/board/detail";
    }

    @GetMapping("/auth/board")
    public String saveForm(@ModelAttribute("boardSaveInDTO") BoardSave_InDTO boardSaveInDTO) {
        log.debug("GET - 게시글 등록 페이지");
        return "pages/board/saveForm";
    }

    @PostMapping("/auth/board")
    public String save(@ModelAttribute("boardSaveInDTO") @Valid BoardSave_InDTO boardSaveInDTO, BindingResult bindingResult,
                       @AuthenticationPrincipal MyUserDetails myUserDetails) {
        log.debug("POST - 게시글 등록");
        if (bindingResult.hasErrors()){
            return "pages/board/saveForm";
        }
        boardService.save(boardSaveInDTO, myUserDetails.getUser().getId());

        return "redirect:/board/list";
    }

    @DeleteMapping("/auth/board/{boardId}")
    public ResponseEntity<?> save(@PathVariable Long boardId, @AuthenticationPrincipal MyUserDetails myUserDetails) {
        log.debug("DELETE - 게시글 삭제");
        boardService.delete(boardId, myUserDetails.getUser().getId());

        return ResponseEntity.ok().body(new ResponseDTO<>().data("ok"));
    }

    @GetMapping("/auth/board/{boardId}")
    public String updateForm(@PathVariable Long boardId, @AuthenticationPrincipal MyUserDetails myUserDetails, Model model) {
        log.debug("GET - 게시글 수정 페이지");
        model.addAttribute("board", boardService.updateForm(boardId, myUserDetails.getUser().getId()));

        return "pages/board/updateForm";
    }
}
