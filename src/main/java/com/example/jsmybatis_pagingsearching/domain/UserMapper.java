package com.example.jsmybatis_pagingsearching.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public Integer insert(User user);

    public List<User> findByAll();

    public User findByUsername(String username);

    public User findById(Long id);

    public Integer updateById(User user);

    public Integer deleteById(Long id);
}
