package com.franc.restful.global.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class GExceptionResponseDTO {
    private String errorCode;
    private String errorMessage;
}
