package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.Cource;
import com.example.cources.models.OwnedCource;
import com.example.cources.repo.CourceRepo;
import com.example.cources.repo.OwnedCourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnedCourceController {
    @Autowired
    OwnedCourceRepo repo;
    @GetMapping("/owned-cource")
    Iterable<OwnedCource> getAll() {
        return repo.findAll();
    }

    @PostMapping("/owned-cource")
    OwnedCource newOwnedCource(@RequestBody OwnedCource ownedCource) {
        return repo.save(ownedCource);
    }

    @GetMapping("/owned-cource/{id}")
    OwnedCource getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "OwnedCource"));
    }

    @PutMapping("/owned-cource/{id}")
    OwnedCource editOwnedCource(@RequestBody OwnedCource newOwnedCource, @PathVariable Long id) {

        return repo.findById(id)
                .map(ownedCource -> {
                    ownedCource.setOwnedLessons(newOwnedCource.getOwnedLessons());
                    return repo.save(ownedCource);
                })
                .orElseThrow(() -> new NotFoundException(id, "OwnedCource"));
    }

    @DeleteMapping("/owned-cource/{id}")
    void deleteOwnedCource(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
