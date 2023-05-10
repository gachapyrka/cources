package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.OwnedLesson;
import com.example.cources.models.OwnedStep;
import com.example.cources.repo.OwnedLessonRepo;
import com.example.cources.repo.OwnedStepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnedStepController {
    @Autowired
    OwnedStepRepo repo;
    @GetMapping("/owned-step")
    Iterable<OwnedStep> getAll() {
        return repo.findAll();
    }

    @PostMapping("/owned-step")
    OwnedStep newOwnedStep(@RequestBody OwnedStep ownedStep) {
        return repo.save(ownedStep);
    }

    @GetMapping("/owned-step/{id}")
    OwnedStep getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "OwnedStep"));
    }

    @PutMapping("/owned-step/{id}")
    OwnedStep editOwnedStep(@RequestBody OwnedStep newOwnedStep, @PathVariable Long id) {

        return repo.findById(id)
                .map(ownedStep -> {
                    ownedStep.setOwnedTopics(newOwnedStep.getOwnedTopics());
                    return repo.save(ownedStep);
                })
                .orElseThrow(() -> new NotFoundException(id, "OwnedStep"));
    }

    @DeleteMapping("/owned-step/{id}")
    void deleteOwnedStep(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
