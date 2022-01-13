package com.franc.restful.global.validation.annotation;

import com.franc.restful.global.validation.TelValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 변수 위에 사용하는 어노테이션이기 때문에 Target=FIELD
@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 유지범위 = RUNTIME
@Constraint(validatedBy = TelValidator.class) // 검증 클래스를 지정
public @interface Tel {
    String message() default "올바른 형식의 휴대폰 번호를 입력하세요"; // 기본 메세지 설정

    // 이외에 groups, payload 설정을 할 수 있다. (따로 설정하진 않은 상태)
    Class[] groups() default {};
    Class[] payload() default {};
}
