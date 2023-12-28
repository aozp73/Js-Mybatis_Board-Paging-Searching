package com.example.jsmybatis_pagingsearching.advice.exception.statuscode;

import com.example.jsmybatis_pagingsearching.advice.exception.ResponseDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception400 extends RuntimeException {
    public Exception400(String message) {
        super(message);
    }

    public ResponseDTO<?> body() {
        ResponseDTO<String> responseDto = new ResponseDTO<>();
        responseDto.fail(HttpStatus.BAD_REQUEST, "badRequest", getMessage());
        return responseDto;
    }

    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }
}

