package com.securebank.api.service;

import com.securebank.api.model.Account;
import com.securebank.api.repository.AccountRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsForUser(String username) {
        return accountRepository.findByOwnerIgnoreCase(username);
    }

    public Account getAccount(Long id, String username) {

        Account account = accountRepository.findById(id)
                .orElse(null);

        if (account == null) {
            return null;
        }

        if (!account.getOwner().equalsIgnoreCase(username)) {
            throw new AccessDeniedException("Access denied");
        }

        return account;
    }
}
