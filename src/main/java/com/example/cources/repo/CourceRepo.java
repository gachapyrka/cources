package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.Cource;
import org.springframework.data.repository.CrudRepository;

public interface CourceRepo extends CrudRepository<Cource, Long> {
}
