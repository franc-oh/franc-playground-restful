package com.franc.restful.global.exception;

import com.franc.restful.global.dto.GExceptionResponseDTO;
import com.franc.restful.global.exception.customException.CAccountNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GExceptionHandler {

    @ExceptionHandler(CAccountNotFoundException.class)
    public ResponseEntity<GExceptionResponseDTO> accountNotFoundExceptionHandler(
            HttpServletRequest req, Exception e) {

        e.printStackTrace();

        String errorMessage = e.getMessage() != null ? e.getMessage() : GExceptionEnum.ACCOUNT_NOT_FOUND_EXCEPTION.getMessage();

        return ResponseEntity
                .status(GExceptionEnum.ACCOUNT_NOT_FOUND_EXCEPTION.getStatus())
                .body(GExceptionResponseDTO.builder()
                        .errorCode(GExceptionEnum.ACCOUNT_NOT_FOUND_EXCEPTION.getCode())
                        .errorMessage(errorMessage)
                        .build());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GExceptionResponseDTO> methodArgNotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {

        e.printStackTrace();

        String errorMessage = e.getBindingResult() != null ? e.getBindingResult().toString() : GExceptionEnum.VALIDATION_FAILED.getMessage();

        return ResponseEntity
                .status(GExceptionEnum.VALIDATION_FAILED.getStatus())
                .body(GExceptionResponseDTO.builder()
                        .errorCode(GExceptionEnum.VALIDATION_FAILED.getCode())
                        .errorMessage(errorMessage)
                        .build());
    }

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
