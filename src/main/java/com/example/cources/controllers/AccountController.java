package com.example.cources.controllers;

import com.example.cources.models.Account;
import com.example.cources.models.enums.Role;
import com.example.cources.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cources.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@RestController
public class AccountController {
    @Autowired
    AccountRepo repo;
    @GetMapping("/account")
    Iterable<Account> getAll() {
        repo.save(new Account(1L, "admin@admin.com", "admin", "Администратор", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashSet<>(Arrays.asList(Role.ADMIN, Role.USER, Role.EDITOR))));
        return repo.findAll();
    }

    @PostMapping("/account")
    Account newEmployee(@RequestBody Account newAccount) {
        return repo.save(newAccount);
    }

    @GetMapping("/account/{id}")
    Account getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Account"));
    }

    @PutMapping("/account/{id}")
    Account editAccount(@RequestBody Account newAccount, @PathVariable Long id) {

        return repo.findById(id)
                .map(account -> {
                    account.setCredentials(newAccount.getCredentials());
                    account.setRoles(newAccount.getRoles());
                    account.setActive(newAccount.isActive());
                    return repo.save(account);
                })
                .orElseThrow(() -> new NotFoundException(id, "Account"));
    }

    @DeleteMapping("/account/{id}")
    void deleteAccount(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
