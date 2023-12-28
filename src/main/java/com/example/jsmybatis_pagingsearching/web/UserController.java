package com.example.jsmybatis_pagingsearching.web;

import com.example.jsmybatis_pagingsearching.web.dto.JoinInDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {

    @GetMapping("/loginForm")
    public String loginForm() {
        log.debug("POST - 로그인 페이지");
        return "user/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        log.debug("POST - 회원가입 페이지");
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute JoinInDTO joinInDTO) {
        log.debug("POST - 회원가입");

        return "redirect:/list";
    }

}
