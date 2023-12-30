package com.example.jsmybatis_pagingsearching.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public Integer insert(Comment comment);

    public List<Board> findAll();

    public Board findById(Long id);

    public Integer updateById(Comment comment);

    public Integer deleteById(Long id);
}
