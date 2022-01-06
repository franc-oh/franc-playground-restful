package com.franc.restful.domain.account.controller;

import com.franc.restful.domain.account.domain.Account;
import com.franc.restful.domain.account.dto.AccountDTO;
import com.franc.restful.domain.account.dto.AccountResponseDTO;
import com.franc.restful.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

        AccountResponseDTO res = new AccountResponseDTO();
        res.setResCd("0000");
        res.setResMsg("SUCCESS");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> selectAccount(@PathVariable Long id) throws Exception{

        Account account = accountRepository.findById(id).orElseThrow(Exception::new);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setName(account.getName());
        accountDTO.setNickname(account.getNickname());
        accountDTO.setPhoneNo(account.getPhoneNo());
        accountDTO.setSex(account.getSex());

        AccountResponseDTO res = new AccountResponseDTO();
        res.setResCd("0000");
        res.setResMsg("SUCCESS");
        res.setData(accountDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
