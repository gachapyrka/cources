package com.example.cources.repo;

import com.example.cources.models.Account;
import com.example.cources.models.CourceComment;
import org.springframework.data.repository.CrudRepository;

public interface CourceCommentRepo extends CrudRepository<CourceComment, Long> {
}
