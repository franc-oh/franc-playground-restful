package com.franc.restful.domain.account.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String phoneNo;

    private String sex;

    private String nickname;

    @Builder
    public Account(String name, String email, String phoneNo, String sex, String nickname) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.sex = sex;
        this.nickname = nickname;
    }
}
