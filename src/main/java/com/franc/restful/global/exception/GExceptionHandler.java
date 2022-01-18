package com.franc.restful.global.exception;

import com.franc.restful.global.dto.GExceptionResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GExceptionResponseDTO> exceptionHandler(HttpServletRequest req, Exception e) {

        e.printStackTrace();

        String errorMessage = e.getMessage() != null ? e.getMessage() : GExceptionEnum.INTERNAL_SERVER_ERROR.getMessage();

        return ResponseEntity
                .status(GExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(GExceptionResponseDTO.builder()
                        .errorCode(GExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                        .errorMessage(errorMessage)
                        .build());
    }
}
