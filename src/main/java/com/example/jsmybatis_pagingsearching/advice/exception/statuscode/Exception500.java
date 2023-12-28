package com.example.jsmybatis_pagingsearching.advice.exception.statuscode;

import com.example.jsmybatis_pagingsearching.advice.exception.ResponseDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception500 extends RuntimeException {
    public Exception500(String message) {
        super(message);
    }

    public ResponseDTO<?> body() {
        ResponseDTO<String> responseDto = new ResponseDTO<>();
        responseDto.fail(HttpStatus.INTERNAL_SERVER_ERROR, "serverError", getMessage());
        return responseDto;
    }

    public HttpStatus status() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}