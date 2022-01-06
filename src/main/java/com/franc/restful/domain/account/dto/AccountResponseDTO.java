package com.franc.restful.domain.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.franc.restful.global.dto.ResponseDTO;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class AccountResponseDTO extends ResponseDTO {

    private AccountDTO data;

}
