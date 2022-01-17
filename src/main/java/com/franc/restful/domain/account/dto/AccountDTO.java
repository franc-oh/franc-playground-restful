package com.franc.restful.domain.account.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountDTO {

    private Long id;

    private String name;

    private String email;

    private String phoneNo;

    private String sex;

    private String nickname;

}
