package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.Cource;
import com.example.cources.models.CourceComment;
import com.example.cources.repo.CourceCommentRepo;
import com.example.cources.repo.CourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourceCommentController {
    @Autowired
    CourceCommentRepo repo;
    @GetMapping("/cource-comment")
    Iterable<CourceComment> getAll() {
        return repo.findAll();
    }

    @PostMapping("/cource-comment")
    CourceComment newCourceComment(@RequestBody CourceComment courceComment) {
        return repo.save(courceComment);
    }

    @GetMapping("/cource-comment/{id}")
    CourceComment getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "CourceComment"));
    }

    @PutMapping("/cource-comment/{id}")
    CourceComment editCourceComment(@RequestBody CourceComment newCourceComment, @PathVariable Long id) {

        return repo.findById(id)
                .map(courceComment -> {
                    courceComment.setDate(newCourceComment.getDate());
                    courceComment.setMessage(newCourceComment.getMessage());
                    return repo.save(courceComment);
                })
                .orElseThrow(() -> new NotFoundException(id, "CourceComment"));
    }

    @DeleteMapping("/cource-comment/{id}")
    void deleteCourceComment(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
