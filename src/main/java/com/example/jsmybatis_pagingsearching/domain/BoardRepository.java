package com.example.jsmybatis_pagingsearching.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
    public Integer insert(Board board);

    public List<Board> findByAll();

    public Board findById(Long id);

    public Integer updateById(Board board);

    public Integer deleteById(Long id);
}
