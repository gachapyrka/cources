package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.Lesson;
import com.example.cources.models.Step;
import com.example.cources.repo.LessonRepo;
import com.example.cources.repo.StepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LessonController {
    @Autowired
    LessonRepo repo;
    @GetMapping("/lesson")
    Iterable<Lesson> getAll() {
        return repo.findAll();
    }

    @PostMapping("/lesson")
    Lesson newLesson(@RequestBody Lesson lesson) {
        return repo.save(lesson);
    }

    @GetMapping("/lesson/{id}")
    Lesson getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Lesson"));
    }

    @PutMapping("/lesson/{id}")
    Lesson editLesson(@RequestBody Lesson newLesson, @PathVariable Long id) {

        return repo.findById(id)
                .map(lesson -> {
                    lesson.setName(newLesson.getName());
                    lesson.setDescription(newLesson.getDescription());
                    return repo.save(lesson);
                })
                .orElseThrow(() -> new NotFoundException(id, "Lesson"));
    }

    @DeleteMapping("/lesson/{id}")
    void deleteLesson(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
