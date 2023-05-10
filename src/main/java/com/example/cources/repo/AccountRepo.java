package com.example.cources.repo;

import com.example.cources.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
}
