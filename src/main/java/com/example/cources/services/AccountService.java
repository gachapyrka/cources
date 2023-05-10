package com.example.cources.services;

import com.example.cources.repo.AccountRepo;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
}
