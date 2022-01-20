package com.franc.restful.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2 // swagger2 활성화
public class SwaggerConfig {
    private static final String API_NAME = "Franc API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "Franc API 명세서";

    /**
     * Swagger 설정
     */
    @Bean
    public Docket api() {
        // 전역 파라미터 설정 (Header에 'AUTHORIZATION' 추가)
        Parameter parameterBuilder = new ParameterBuilder()
                .name(HttpHeaders.AUTHORIZATION)
                .description("Access Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        List<Parameter> globalParamters = new ArrayList<>();
        globalParamters.add(parameterBuilder);

        /*
            globalOperationParameters() : 전역 파라미터
            apiInfo() : 문서에 명시될 API정보
            select() : ApiSelectorBuilder를 생성
            apis() : 문서화 범위를 지정 (basePackage 하위 API들은 모두 문서화 대상이 됨)
            paths() : 문서화 대상을 특정 조건으로 필터링 (any() 대신 ant(url pattern) 사용)
            groupName() : Docket이 1개일 경우 생략가능, 여러개일 경우 충돌하지 않도록 지정
         */
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(globalParamters)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.franc.restful"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 문서에 명시될 API정보 설정 (제목, 설명, 버젼 등등...)
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }
}
