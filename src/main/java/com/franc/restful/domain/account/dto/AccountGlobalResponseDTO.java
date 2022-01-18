package com.franc.restful.domain.account.dto;

import com.franc.restful.global.dto.GApiResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountGlobalResponseDTO<T> extends GApiResponseDTO {
    private T data;
}
