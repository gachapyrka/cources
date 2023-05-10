package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.OwnedStep;
import com.example.cources.models.OwnedTopic;
import com.example.cources.repo.OwnedStepRepo;
import com.example.cources.repo.OwnedTopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnedTopicController {
    @Autowired
    OwnedTopicRepo repo;
    @GetMapping("/owned-topic")
    Iterable<OwnedTopic> getAll() {
        return repo.findAll();
    }

    @PostMapping("/owned-topic")
    OwnedTopic newOwnedTopic(@RequestBody OwnedTopic ownedTopic) {
        return repo.save(ownedTopic);
    }

    @GetMapping("/owned-topic/{id}")
    OwnedTopic getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "OwnedTopic"));
    }

    @PutMapping("/owned-topic/{id}")
    OwnedTopic editOwnedTopic(@RequestBody OwnedTopic newOwnedTopic, @PathVariable Long id) {

        return repo.findById(id)
                .map(ownedTopic -> {
                    ownedTopic.setDone(newOwnedTopic.isDone());
                    return repo.save(ownedTopic);
                })
                .orElseThrow(() -> new NotFoundException(id, "OwnedTopic"));
    }

    @DeleteMapping("/owned-topic/{id}")
    void deleteOwnedTopic(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
