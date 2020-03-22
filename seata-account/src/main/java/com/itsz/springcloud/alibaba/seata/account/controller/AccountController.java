package com.itsz.springcloud.alibaba.seata.account.controller;

import com.itsz.springcloud.alibaba.seata.domain.Account;
import com.itsz.springcloud.alibaba.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.selectAll();
    }


}
