package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.Step;
import com.example.cources.models.Topic;
import com.example.cources.repo.StepRepo;
import com.example.cources.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StepController {
    @Autowired
    StepRepo repo;
    @GetMapping("/step")
    Iterable<Step> getAll() {
        return repo.findAll();
    }

    @PostMapping("/step")
    Step newStep(@RequestBody Step step) {
        return repo.save(step);
    }

    @GetMapping("/step/{id}")
    Step getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Step"));
    }

    @PutMapping("/step/{id}")
    Step editStep(@RequestBody Step newStep, @PathVariable Long id) {

        return repo.findById(id)
                .map(topic -> {
                    topic.setName(newStep.getName());
                    topic.setDescription(newStep.getDescription());
                    return repo.save(topic);
                })
                .orElseThrow(() -> new NotFoundException(id, "Step"));
    }

    @DeleteMapping("/step/{id}")
    void deleteStep(@PathVariable Long id) {
        repo.deleteById(id);
    }
}