package com.example.cources.repo;

import com.example.cources.models.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepo extends CrudRepository<ChatMessage, Long> {
}
