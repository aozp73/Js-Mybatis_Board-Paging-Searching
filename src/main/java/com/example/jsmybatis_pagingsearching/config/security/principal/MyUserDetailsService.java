package com.example.jsmybatis_pagingsearching.config.security.principal;

import com.example.jsmybatis_pagingsearching.domain.User;
import com.example.jsmybatis_pagingsearching.domain.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserMapper userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("올바르지 않은 정보입니다.");
        }

        return new MyUserDetails(user);
    }
}