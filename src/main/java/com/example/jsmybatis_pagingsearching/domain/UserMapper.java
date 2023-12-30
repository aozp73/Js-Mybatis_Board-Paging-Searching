package com.example.jsmybatis_pagingsearching.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public Integer insert(User user);

    public List<User> findAll();

    public User findByUsername(String username);

    public User findById(Long id);

    public User findByEmail(String email);

    public Integer updateById(User user);

    public Integer deleteById(Long id);
}
