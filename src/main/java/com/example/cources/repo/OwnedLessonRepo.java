package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.OwnedLesson;
import org.springframework.data.repository.CrudRepository;

public interface OwnedLessonRepo extends CrudRepository<OwnedLesson, Long> {
}
