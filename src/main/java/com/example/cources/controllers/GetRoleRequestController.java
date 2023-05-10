package com.example.cources.controllers;

import com.example.cources.exceptions.NotFoundException;
import com.example.cources.models.Cource;
import com.example.cources.models.GetRoleRequest;
import com.example.cources.models.Step;
import com.example.cources.repo.CourceRepo;
import com.example.cources.repo.GetRoleRequestRepo;
import com.example.cources.services.GetRoleRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetRoleRequestController {
    @Autowired
    GetRoleRequestRepo repo;
    @Autowired
    GetRoleRequestService service;
    @GetMapping("/get-role-request")
    Iterable<GetRoleRequest> getAll() {
        return repo.findAll();
    }

    @PostMapping("/get-role-request")
    GetRoleRequest newGetRoleRequest(@RequestBody GetRoleRequest cource) {
        return repo.save(cource);
    }

    @GetMapping("/get-role-request/{id}")
    GetRoleRequest getOne(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Cource"));
    }

    @PutMapping("/get-role-request/{id}")
    GetRoleRequest editGetRoleRequest(@RequestBody GetRoleRequest newGetRoleRequest, @PathVariable Long id) {

        return repo.findById(id)
                .map(cource -> {
                    cource.setRole(newGetRoleRequest.getRole());
                    cource.setMessage(newGetRoleRequest.getMessage());
                    return repo.save(cource);
                })
                .orElseThrow(() -> new NotFoundException(id, "Cource"));
    }

    @PostMapping("/get-role-request/accept/{id}")
    void acceptGetRoleRequest(@PathVariable Long id) {
        service.AcceptGetRoleRequest(id);
    }

    @PostMapping("/get-role-request/deny/{id}")
    void denyGetRoleRequest(@PathVariable Long id) {
        service.DenyGetRoleRequest(id);
    }

    @DeleteMapping("/get-role-request/{id}")
    void deleteGetRoleRequest(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
