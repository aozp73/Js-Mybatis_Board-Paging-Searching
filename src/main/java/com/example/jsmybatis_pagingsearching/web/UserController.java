package com.example.jsmybatis_pagingsearching.web;

import com.example.jsmybatis_pagingsearching.service.UserService;
import com.example.jsmybatis_pagingsearching.web.dto.JoinInDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/loginForm")
    public String loginForm() {
        log.debug("GET - 로그인 페이지");
        return "user/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        log.debug("GET - 회원가입 페이지");
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute JoinInDTO joinInDTO) {
        log.debug("POST - 회원가입");
        userService.save(joinInDTO);
        return "redirect:/list";
    }

    @ResponseBody
    @GetMapping("/emailCheck")
    public ResponseEntity<?> join(@RequestParam String email) {
        log.debug("POST - 이메일 체크");
        boolean isValid = userService.emailCheck(email);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }

}
