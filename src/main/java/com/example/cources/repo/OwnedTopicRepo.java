package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.OwnedTopic;
import org.springframework.data.repository.CrudRepository;

public interface OwnedTopicRepo extends CrudRepository<OwnedTopic, Long> {
}
