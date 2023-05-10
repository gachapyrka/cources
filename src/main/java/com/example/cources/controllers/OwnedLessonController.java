package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.OwnedCource;
import com.example.cources.models.OwnedLesson;
import com.example.cources.repo.OwnedCourceRepo;
import com.example.cources.repo.OwnedLessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnedLessonController {
    @Autowired
    OwnedLessonRepo repo;
    @GetMapping("/owned-lesson")
    Iterable<OwnedLesson> getAll() {
        return repo.findAll();
    }

    @PostMapping("/owned-lesson")
    OwnedLesson newOwnedLesson(@RequestBody OwnedLesson ownedLesson) {
        return repo.save(ownedLesson);
    }

    @GetMapping("/owned-lesson/{id}")
    OwnedLesson getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "OwnedLesson"));
    }

    @PutMapping("/owned-lesson/{id}")
    OwnedLesson editOwnedLesson(@RequestBody OwnedLesson newOwnedLesson, @PathVariable Long id) {

        return repo.findById(id)
                .map(ownedLesson -> {
                    ownedLesson.setOwnedSteps(newOwnedLesson.getOwnedSteps());
                    return repo.save(ownedLesson);
                })
                .orElseThrow(() -> new NotFoundException(id, "OwnedLesson"));
    }

    @DeleteMapping("/owned-lesson/{id}")
    void deleteOwnedLesson(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
