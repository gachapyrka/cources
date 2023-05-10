package com.example.cources.services;

import com.example.cources.models.GetRoleRequest;
import com.example.cources.repo.AccountRepo;
import com.example.cources.repo.GetRoleRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRoleRequestService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private GetRoleRequestRepo getRoleRequestRepo;

    public void AcceptGetRoleRequest(Long id){

    }

    public void DenyGetRoleRequest(Long id){

    }
}
