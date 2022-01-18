package com.franc.restful.global.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum GExceptionEnum {
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001", "BAD_REQUEST ERROR"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002", "UNAUTHORIZED ERROR"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003", "INTERNAL SERVER ERROR"),
    SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "권한이 없습니다.");



    private HttpStatus status;
    private String code;
    private String message;

    GExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
