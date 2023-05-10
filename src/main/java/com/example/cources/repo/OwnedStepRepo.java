package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.OwnedStep;
import org.springframework.data.repository.CrudRepository;

public interface OwnedStepRepo extends CrudRepository<OwnedStep, Long> {
}
