package com.example.jsmybatis_pagingsearching.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public Integer insert(Board board);

    public List<Board> findAll();

    public Board findById(Long id);

    public Integer updateById(Board board);

    public Integer deleteById(Long id);
}
