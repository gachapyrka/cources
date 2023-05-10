package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.Step;
import org.springframework.data.repository.CrudRepository;

public interface StepRepo extends CrudRepository<Step, Long> {
}
