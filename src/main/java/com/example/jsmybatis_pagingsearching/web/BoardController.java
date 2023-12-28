package com.example.jsmybatis_pagingsearching.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

    @GetMapping("/list")
    public String list() {
        log.debug("GET - 글 목록 페이지");
        return "board/list";
    }
    
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id) {
        log.debug("GET - 상세 페이지 요청");
        return "board/detail";
    }

    @GetMapping("/saveForm")
    public String saveForm() {
        log.debug("GET - 글 수정 페이지");
        return "board/saveForm";
    }

}
