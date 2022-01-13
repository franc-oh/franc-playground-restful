package com.franc.restful.global.validation;

import com.franc.restful.global.validation.annotation.Tel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// 검증 클래스를 만들기 위해서는 ConstraintValidator를 구현 <검증어노테이션, 필드의 데이터 타입>
public class TelValidator implements ConstraintValidator<Tel, String> {

    // isValid() 메서드를 재정의 하여 검증 로직 작성
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null)
            return false;

        return value.matches("(01[016789])(\\d{3,4})(\\d{4})");
    }
}
