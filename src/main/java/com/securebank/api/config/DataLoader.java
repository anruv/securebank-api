package com.securebank.api.config;

import com.securebank.api.model.Account;
import com.securebank.api.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) {

        accountRepository.save(
            new Account(1001L, "Alice", 5000.00)
        );

        accountRepository.save(
            new Account(1002L, "Bob", 12000.00)
        );

        accountRepository.save(
            new Account(1003L, "Charlie", 750.00)
        );
    }
}
