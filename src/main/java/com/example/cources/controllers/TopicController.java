package com.example.cources.controllers;

import com.example.cources.models.Account;
import com.example.cources.models.Topic;
import com.example.cources.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cources.exceptions.NotFoundException;

@RestController
public class TopicController {
    @Autowired
    TopicRepo repo;
    @GetMapping("/topic")
    Iterable<Topic> getAll() {
        return repo.findAll();
    }

    @PostMapping("/topic")
    Topic newTopic(@RequestBody Topic topic) {
        return repo.save(topic);
    }

    @GetMapping("/topic/{id}")
    Topic getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Topic"));
    }

    @PutMapping("/topic/{id}")
    Topic editTopic(@RequestBody Topic newTopic, @PathVariable Long id) {

        return repo.findById(id)
                .map(topic -> {
                    topic.setContent(newTopic.getContent());
                    topic.setType(newTopic.getType());
                    return repo.save(topic);
                })
                .orElseThrow(() -> new NotFoundException(id, "Topic"));
    }

    @DeleteMapping("/topic/{id}")
    void deleteTopic(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

