package com.franc.restful.global.exception.customException;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CAccountNotFoundException extends RuntimeException{
    public CAccountNotFoundException(String message) {
        super(message);
    }
}
