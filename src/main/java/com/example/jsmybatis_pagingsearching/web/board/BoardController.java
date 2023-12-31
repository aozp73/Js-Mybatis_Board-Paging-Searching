package com.example.jsmybatis_pagingsearching.web.board;

import com.example.jsmybatis_pagingsearching.config.security.principal.MyPrincipalDetails;
import com.example.jsmybatis_pagingsearching.service.BoardService;
import com.example.jsmybatis_pagingsearching.web.board.dto.BoardDetail_OutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String list(Model model) {
        log.debug("GET - 글 목록 페이지");
        model.addAttribute("boardList", boardService.findAll());

        return "board/list";
    }
    
    @GetMapping("/board/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        log.debug("GET - 상세 페이지 요청");
        model.addAttribute("boardList", boardService.findById(id));

        return "board/detail";
    }

    @GetMapping("/auth/saveForm")
    public String saveForm() {
        log.debug("GET - 글 등록 페이지");
        return "board/saveForm";
    }

}
