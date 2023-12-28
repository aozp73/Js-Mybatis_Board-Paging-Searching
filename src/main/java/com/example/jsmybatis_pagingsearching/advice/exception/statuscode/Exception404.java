package com.example.jsmybatis_pagingsearching.advice.exception.statuscode;

import com.example.jsmybatis_pagingsearching.advice.exception.ResponseDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception404 extends RuntimeException {
    public Exception404(String message) {
        super(message);
    }

    public ResponseDTO<?> body() {
        ResponseDTO<String> responseDto = new ResponseDTO<>();
        responseDto.fail(HttpStatus.NOT_FOUND, "notFound", getMessage());
        return responseDto;
    }

    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}
