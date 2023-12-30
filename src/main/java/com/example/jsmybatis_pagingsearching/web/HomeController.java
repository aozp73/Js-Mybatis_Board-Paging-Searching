package com.example.jsmybatis_pagingsearching.web;

import com.example.jsmybatis_pagingsearching.config.security.principal.MyPrincipalDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String list() {
        log.debug("GET - Home 페이지");
        return "home";
    }

}
