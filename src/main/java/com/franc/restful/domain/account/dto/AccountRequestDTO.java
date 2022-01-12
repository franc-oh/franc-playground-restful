package com.franc.restful.domain.account.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AccountRequestDTO {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @Size(min = 11, max = 11, message = "핸드폰 번호는 '-'을 제외한 11자리로 입력해주세요.")
    private String phoneNo;

    private String sex;

    private String nickname;
}
