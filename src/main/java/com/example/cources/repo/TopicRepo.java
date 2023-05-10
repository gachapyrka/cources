package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepo extends CrudRepository<Topic, Long> {
}
