package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.OwnedCource;
import org.springframework.data.repository.CrudRepository;

public interface OwnedCourceRepo extends CrudRepository<OwnedCource, Long> {
}
