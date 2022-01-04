package com.franc.restful.domain.account.controller;

import com.franc.restful.domain.account.domain.Account;
import com.franc.restful.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountRepository accountRepository;

    @PostMapping("/accounts")
    public ResponseEntity<?> insertAccount(@RequestBody HashMap<String, String> req) {

        accountRepository.save(Account.builder()
                        .email((String) req.get("email"))
                        .name((String) req.get("name"))
                        .nickname((String) req.get("nickname"))
                        .phoneNo((String) req.get("phoneNo"))
                        .sex((String) req.get("sex"))
                        .build());

        Map<String, Object> res = new HashMap<>();
        res.put("resCd", "0000");
        res.put("resMsg", "SUCCESS");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
