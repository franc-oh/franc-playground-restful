package com.franc.restful.domain.account.controller;

import javax.validation.*;

import com.franc.restful.domain.account.domain.Account;
import com.franc.restful.domain.account.dto.AccountDTO;
import com.franc.restful.domain.account.dto.AccountRequestDTO;
import com.franc.restful.domain.account.dto.AccountGlobalResponseDTO;
import com.franc.restful.domain.account.repository.AccountRepository;
import com.franc.restful.global.exception.GExceptionEnum;
import com.franc.restful.global.exception.customException.CAccountNotFoundException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountRepository accountRepository;

    @PostMapping("/accounts")
    public ResponseEntity<?> insert(@RequestBody @Valid AccountRequestDTO request) {
        Map<String, Object> response = new HashMap<>();
        String resCd = "0000";
        String resMsg = "SUCCESS";

        accountRepository.save(Account.builder()
                        .email(request.getEmail())
                        .name(request.getName())
                        .nickname(request.getNickname())
                        .phoneNo(request.getPhoneNo())
                        .sex(request.getSex())
                        .build());

        response.put("resCd", resCd);
        response.put("resMsg", resMsg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    @ApiOperation(value = "사용자 조회", notes = "사용자 ID로 사용자 정보를 조회한다.")
    @ApiImplicitParam(name = "id", value = "사용자 ID", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR")
    })
    public ResponseEntity<AccountGlobalResponseDTO> getAccount(@PathVariable Long id) throws Exception{

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new CAccountNotFoundException());

        AccountDTO accountDTO = AccountDTO.builder()
                .id(account.getId())
                .name(account.getName())
                .email(account.getEmail())
                .nickname(account.getNickname())
                .phoneNo(account.getPhoneNo())
                .sex(account.getSex())
                .build();

        AccountGlobalResponseDTO res = new AccountGlobalResponseDTO();
        res.setResCd("0000");
        res.setResMsg("SUCCESS");
        res.setData(accountDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/accounts/test/validation")
    public void validationTest() {

        AccountDTO account = AccountDTO.builder()
                .build();

        log.info("validation : " + validateDto(account));

        AccountDTO account2 = AccountDTO.builder()
                .id(1L)
                .name("ddd")
                .email("fr@naver.com")
                .nickname("zzzz")
                .sex("M")
                .phoneNo("01023220000")
                .build();

        log.info("validation2 : " + validateDto(account2));
    }


    public boolean validateDto(Object obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Object>> violations = validator.validate(obj);

        for (ConstraintViolation<Object> violation : violations) {
            log.info("err : " + violation.getPropertyPath() + " - " + violation.getMessage());
        }

        if(!violations.isEmpty()) return false;

        return true;
    }
}
