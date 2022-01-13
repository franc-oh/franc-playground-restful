package com.franc.restful.domain.account.dto;

import com.franc.restful.global.validation.annotation.Tel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AccountRequestDTO {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @Email(message = "이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @Tel
    private String phoneNo;

    private String sex;

    private String nickname;
}
