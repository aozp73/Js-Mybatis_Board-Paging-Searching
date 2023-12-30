package com.example.jsmybatis_pagingsearching.web.user;

import com.example.jsmybatis_pagingsearching.config.security.jwt.MyJwtUtil;
import com.example.jsmybatis_pagingsearching.config.security.principal.MyPrincipalDetails;
import com.example.jsmybatis_pagingsearching.service.UserService;
import com.example.jsmybatis_pagingsearching.web.user.dto.Join_InDTO;
import com.example.jsmybatis_pagingsearching.web.user.dto.Login_InDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MyJwtUtil myJwtUtil;

    // 회원 가입
    @GetMapping("/joinForm")
    public String joinForm(@ModelAttribute Join_InDTO joinInDTO) {
        log.debug("GET - 회원가입 페이지");
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute @Valid Join_InDTO joinInDTO, BindingResult bindingResult) {
        log.debug("POST - 회원가입");
        // 유효성 체크 실패 시, 필드값 그대로 담아서 페이지 응답
        if (bindingResult.hasErrors()){
            return "/user/joinForm";
        }

        userService.save(joinInDTO);
        return "redirect:/loginForm";
    }

    // 회원 가입 - 이메일 체크
    @ResponseBody
    @GetMapping("/emailCheck")
    public ResponseEntity<?> emailCheck(@RequestParam String email) {
        log.debug("POST - 이메일 체크");
        boolean isValid = userService.emailCheck(email);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }

    // 로그인
    @GetMapping("/loginForm")
    public String loginForm() {
        log.debug("GET - 로그인 페이지");
        return "user/loginForm";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(Login_InDTO loginInDTO) {
        log.debug("POST - 로그인");

        String jwt = userService.login(loginInDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", jwt);

        return new ResponseEntity<>("Ok", headers, HttpStatus.OK);
    }

    @GetMapping("/validateToken")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
        String jwt = token.replace(myJwtUtil.TOKEN_PREFIX, "");
        boolean isValid = myJwtUtil.validateToken(jwt);

        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }

    @GetMapping("/userInfo")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal MyPrincipalDetails myPrincipalDetails) {

        return new ResponseEntity<>(myPrincipalDetails.getUser(), HttpStatus.OK);
    }
}
