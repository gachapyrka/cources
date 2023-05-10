package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.ChatMessage;
import com.example.cources.models.Topic;
import com.example.cources.repo.ChatMessageRepo;
import com.example.cources.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatMessageController {
    @Autowired
    ChatMessageRepo repo;
    @GetMapping("/chat-message")
    Iterable<ChatMessage> getAll() {
        return repo.findAll();
    }

    @PostMapping("/chat-message")
    ChatMessage newChatMessage(@RequestBody ChatMessage chatMessage) {
        return repo.save(chatMessage);
    }

    @GetMapping("/chat-message/{id}")
    ChatMessage getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "ChatMessage"));
    }

    @PutMapping("/chat-message/{id}")
    ChatMessage editChatMessage(@RequestBody ChatMessage newChatMessage, @PathVariable Long id) {

        return repo.findById(id)
                .map(chatMessage -> {
                    chatMessage.setMessage(newChatMessage.getMessage());
                    chatMessage.setDate(newChatMessage.getDate());
                    return repo.save(chatMessage);
                })
                .orElseThrow(() -> new NotFoundException(id, "ChatMessage"));
    }

    @DeleteMapping("/chat-message/{id}")
    void deleteChatMessage(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
