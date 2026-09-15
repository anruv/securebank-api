package com.securebank.api.controller;

import com.securebank.api.model.Account;
import com.securebank.api.service.AccountService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts(Authentication authentication) {
        return accountService.getAccountsForUser(authentication.getName());
    }

    @GetMapping("/{id}")
    public Account getAccount(
            @PathVariable Long id,
            Authentication authentication) {

        return accountService.getAccount(
                id,
                authentication.getName()
        );
    }
}
