package com.franc.restful.global.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GApiResponseDTO {

    @ApiModelProperty(example = "응답코드")
    private String resCd;

    @ApiModelProperty(example = "응답메세지")
    private String resMsg;
}
