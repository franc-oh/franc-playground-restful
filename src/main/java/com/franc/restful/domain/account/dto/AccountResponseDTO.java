package com.franc.restful.domain.account.dto;

import com.franc.restful.global.dto.CommonResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountResponseDTO<T> extends CommonResponseDTO {
    private T data;
}
