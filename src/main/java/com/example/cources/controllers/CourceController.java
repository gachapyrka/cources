package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.Cource;
import com.example.cources.models.Lesson;
import com.example.cources.models.Step;
import com.example.cources.repo.CourceRepo;
import com.example.cources.repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourceController {
    @Autowired
    CourceRepo repo;
    @GetMapping("/cource")
    Iterable<Cource> getAll() {
        return repo.findAll();
    }

    @PostMapping("/cource")
    Cource newCource(@RequestBody Cource cource) {
        return repo.save(cource);
    }

    @GetMapping("/cource/{id}")
    Cource getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Cource"));
    }

    @PutMapping("/cource/{id}")
    Cource editCource(@RequestBody Cource newCource, @PathVariable Long id) {

        return repo.findById(id)
                .map(cource -> {
                    cource.setName(newCource.getName());
                    cource.setDescription(newCource.getDescription());
                    return repo.save(cource);
                })
                .orElseThrow(() -> new NotFoundException(id, "Cource"));
    }

    @DeleteMapping("/cource/{id}")
    void deleteCource(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
