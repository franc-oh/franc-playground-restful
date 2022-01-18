package com.franc.restful.domain.account.controller;

import javax.validation.Valid;

import com.franc.restful.domain.account.domain.Account;
import com.franc.restful.domain.account.dto.AccountDTO;
import com.franc.restful.domain.account.dto.AccountRequestDTO;
import com.franc.restful.domain.account.dto.AccountGlobalResponseDTO;
import com.franc.restful.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
public class AccountRestController {

    private final AccountRepository accountRepository;

    @PostMapping("/accounts")
    public ResponseEntity<?> insert(@RequestBody @Valid AccountRequestDTO request, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        String resCd = "0000";
        String resMsg = "SUCCESS";

        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(objectError -> {
                        log.error("code : " + objectError.getCode());
                        log.error("defaultMessage : " + objectError.getDefaultMessage());
                        log.error("objectName : " + objectError.getObjectName());
                    });

            resCd = "9999";
            resMsg = "FAIL";

            response.put("resCd", resCd);
            response.put("resMsg", resMsg);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
    public ResponseEntity<?> getAccount(@PathVariable Long id) throws Exception{

        if(1==1) throw new Exception("TEST");

        Account account = accountRepository.findById(id).orElseThrow(RuntimeException::new);

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
}
