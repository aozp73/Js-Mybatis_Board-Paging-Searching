package com.example.jsmybatis_pagingsearching.service;

import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.CustomException;
import com.example.jsmybatis_pagingsearching.advice.exception.statuscode.Exception400;
import com.example.jsmybatis_pagingsearching.domain.User;
import com.example.jsmybatis_pagingsearching.domain.UserMapper;
import com.example.jsmybatis_pagingsearching.web.user.UserRole;
import com.example.jsmybatis_pagingsearching.web.user.dto.Join_InDTO;
import com.example.jsmybatis_pagingsearching.web.user.dto.Login_InDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원가입
    public void save(Join_InDTO joinInDTO) {
        log.debug("aa = {}", UserRole.COMMON);
        // 장난 치는거 체크
        if (userRepository.findByEmail(joinInDTO.getEmail()) != null) {
            throw new CustomException("해당 이메일로 가입할 수 없습니다.");
        }

        try {
            userRepository.insert(joinInDTO.toEntity(passwordEncoder));
        } catch (Exception exception) {
            throw new CustomException("회원가입에 실패하였습니다.");
        }
    }

    public Boolean emailCheck(String email) {
        boolean isValid = true;
        if (userRepository.findByEmail(email) != null) {
            isValid = false;
        }

        return isValid;
    }

}
