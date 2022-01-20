package com.franc.restful.domain.account.dto;

import com.franc.restful.global.dto.GApiResponseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountGlobalResponseDTO<T> extends GApiResponseDTO {
    @ApiModelProperty(example = "데이터")
    private T data;
}
