package com.codegym.agoda.controller;

import com.codegym.agoda.model.Account;
import com.codegym.agoda.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("apiAccountController")
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;
    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account){
        Account account1 =  accountService.checkAccount(account);
        if (account1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account1,HttpStatus.OK);
    }

}
